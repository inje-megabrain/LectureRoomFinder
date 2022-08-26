package project_MJ.summer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project_MJ.summer.domain.Users;
import project_MJ.summer.dto.NewUserDto;
import project_MJ.summer.dto.ResponseUserDto;
import project_MJ.summer.repository.UserRepo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service@Slf4j
public class UsersService {

    private final UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // 전체 조회 비즈니스 로직
    public List<ResponseUserDto> getAllUsers() {
        List<Users> users = userRepo.findAll();
        List<ResponseUserDto> dtos = new ArrayList<>();
        for (Users item : users) {
            ResponseUserDto dto = ResponseUserDto
                    .builder()
                    .username(item.getUsername())
                    .identity(item.getIdentity())
                    .build();

            dtos.add(dto);

        }
        return dtos;
    }

    // 아이디로 유저 조회
    public ResponseUserDto getUser(String id) {
        Optional<Users> user = userRepo.findByIdentity(id);
        // 옵셔널은 NPE 방지를 위해 한번 포장해주는 느낌
        user.orElseThrow(() -> {
            return new RuntimeException("해당 아이디의 유저가 없습니다");
        }); // 예외
        // 존재하는거
        ResponseUserDto dto = ResponseUserDto
                .builder()
                .identity(user.get().getIdentity())
                .username(user.get().getUsername())
                .build();
        log.info("조회된 아이디 : {}", dto.getIdentity());
        return dto;

    }

    //로그인 시 계정과 비밀번호가 같은지
    public void checkIDPW(String id, String pw) throws RuntimeException{
        Optional<Users> users = userRepo.findByIdentity(id);
        if (users.get().getId()==null)
            throw new RuntimeException("아이디가 존재하지 않습니다.");
        else{
            if(!passwordEncoder.matches(pw,users.get().getPw()))
                throw new RuntimeException("아이디 비밀번호가 일치하지 않습니다.");
        }

    }
    // 회원 생성 로직
    public void newUser(NewUserDto dto) {
        String encodedPw = passwordEncoder.encode(dto.getPw());
        Users newUser = Users.builder()
                .username(dto.getUsername())
                .pw(encodedPw)
                .identity(dto.getIdentity())
                .build();
        log.info("생성된 아이디 : {} 비밀번호 : {} 닉네임 : {}", newUser.getIdentity(),
                newUser.getPw(), newUser.getUsername());
        userRepo.save(newUser);
    }
    // 아이디 중복 확인
    public void idCheck (String id)throws Exception{
        Optional<Users> user = userRepo.findByIdentity(id);
        user.orElseThrow(() -> {
            log.info("사용가능한 아이디 입니다.");
            return new RuntimeException("사용가능한 아이디 입니다.");
        });
    }
}