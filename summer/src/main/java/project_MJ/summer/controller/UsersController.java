package project_MJ.summer.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_MJ.summer.domain.Users;
import project_MJ.summer.dto.NewUserDto;
import project_MJ.summer.dto.ResponseUserDto;
import project_MJ.summer.jwt.JwtTokenProvider;
import project_MJ.summer.repository.UserRepo;
import project_MJ.summer.service.UsersService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class UsersController {


    private final JwtTokenProvider jwtTokenProvider;
    private UsersService usersService;
    private final UserRepo userRepo;

    @Autowired
    public UsersController(JwtTokenProvider jwtTokenProvider, UsersService usersService, UserRepo userRepo) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.usersService = usersService;
        this.userRepo = userRepo;
    }


    // Create Read Update Delete
    @GetMapping("/users")
    @ApiOperation("전체 유저 조회")
    public ResponseEntity getAllUsers() {
        try {
            List<ResponseUserDto> users = usersService.getAllUsers();
            return new ResponseEntity(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("잘못된 조회", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/get")
    @ApiOperation("해당 계정명으로 유저 조회")
    public ResponseEntity getUser(@RequestParam("identity") String id) {
        try {
            ResponseUserDto users= usersService.getUser(id);
            return new ResponseEntity(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("잘못된 조회", HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin(origins="*")
    @PostMapping("/users/new")
    @ApiOperation("유저 생성")
    public ResponseEntity addNewUser(@RequestBody NewUserDto userDto) {
        try {
            usersService.newUser(userDto);
            return new ResponseEntity("생성되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("잘못된 생성", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/users/id_check")
    @ApiOperation("id 중복 검사")
    public ResponseEntity<Boolean>idCheck(@RequestParam("identity") String id) {
        if(usersService.idCheck(id)){
            log.info("중복된 아이디");
            return new ResponseEntity("중복된 아이디입니다...", HttpStatus.BAD_REQUEST);
        }

        else{
            log.info("사용가능한 아이디");
            return new ResponseEntity("사용 가능한 아이디입니다...", HttpStatus.OK);
        }
    }
    @PostMapping("/users/login")
    @ApiOperation("로그인 시 아이디 비밀번호 일치 후 토큰생성")
    public String logIn(@RequestParam("identity") String identity, @RequestParam("pw") String pw) {

       if(usersService.checkIDPW(identity,pw))
       {
           Users user = userRepo.findByIdentity(identity)
                   .orElseThrow(() -> new IllegalStateException("가입되지 않은 아이디"));
           String access_token = jwtTokenProvider.createToken(user.getIdentity(),user.getPw(),user.getUsername(),user.getRoles());
           return access_token;

       }
       else return null;
    }
}
