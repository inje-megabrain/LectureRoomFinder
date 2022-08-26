package project_MJ.summer.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import project_MJ.summer.dto.NewUserDto;
import project_MJ.summer.dto.ResponseUserDto;
import project_MJ.summer.service.UsersService;

import java.util.List;
@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UsersController {


    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
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
    public ResponseEntity idCheck(@RequestParam("identity") String id) {
        try {
            usersService.idCheck(id);
            return new ResponseEntity("중복된 아이디입니다.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("사용 가능한 아이디입니다.", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/users/login_check")
    @ApiOperation("로그인 시 아이디 비밀번호 일치 확인")
    public ResponseEntity logIn(@RequestParam("identity") String id, @RequestParam("pw") String pw) {
        try{
            usersService.checkIDPW(id,pw);
            return new ResponseEntity("로그인 성공", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("아이디 비밀번호가 다릅니다.", HttpStatus.BAD_REQUEST);
        }
    }
}
