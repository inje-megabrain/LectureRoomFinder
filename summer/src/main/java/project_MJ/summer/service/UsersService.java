package project_MJ.summer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.*;

@Service@Slf4j
public class UsersService implements UserDetailsService{

    private final UserRepo userRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UserRepo userRepo){
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
                    .roles(item.getRoles())
                    .build();

            dtos.add(dto);
            log.info("조회된 유저 아이디 : {}, 닉네임 : {} role : {}",dto.getIdentity(),dto.getUsername(),dto.getRoles());
        }
        return dtos;
    }

    // 아이디로 유저 조회
    public ResponseUserDto getUser(String id) {
        Optional<Users> user = userRepo.findByIdentity(id);
        // 옵셔널은 NPE 방지를 위해 한번 포장해주는 느낌
        user.orElseThrow(() -> {
            log.info("해당 아이디의 유저가 없습니다 !");
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
    public boolean checkIDPW(String id, String json) throws RuntimeException{
        Optional<Users> users = userRepo.findByIdentity(id);
        if(passwordEncoder.matches(json,users.get().getJson())){
            log.info("아이디 비밀번호가 동일 합니다. 로그인한 아이디 : {}",id);
            return true;
        }
        else {
            log.info("아이디 비밀번호가 일치하지 않습니다.");
            return false;
        }

    }
    // 회원 생성 로직
    public void newUser(NewUserDto dto) {
        String encodedPw = passwordEncoder.encode(dto.getJson());
        Users newUser = Users.builder()
                .username(dto.getUsername())
                .json(encodedPw)
                .identity(dto.getIdentity())
                .roles(Collections.singletonList("USER"))
                .build();
        log.info("생성된 아이디 : {} json : {} 닉네임 : {} role {}", newUser.getIdentity(),
                newUser.getJson(), newUser.getUsername(),newUser.getRoles());
        userRepo.save(newUser);
    }
    // 아이디 중복 확인
    public boolean idCheck (String id) {
        return userRepo.existsByIdentity(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> users = userRepo.findByIdentity(username);
        if (users.get().getIdentity() == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        users.get().getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("USER"));
        });
        return new org.springframework.security.core.userdetails.User(users.get().getIdentity(), users.get().getJson(), authorities);
    }
}