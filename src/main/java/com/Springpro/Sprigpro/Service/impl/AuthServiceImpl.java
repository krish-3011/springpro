package com.Springpro.Sprigpro.Service.impl;

import com.Springpro.Sprigpro.Config.JwtConfig;
import com.Springpro.Sprigpro.Entity.Role;
import com.Springpro.Sprigpro.Entity.Users;
import com.Springpro.Sprigpro.LoginRequest;
import com.Springpro.Sprigpro.Repository.UserRepo;
import com.Springpro.Sprigpro.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;

    public Users signUpService(Users user) {
        if (user.getName() == null && userRepo.existsByName(user.getName()) ) {
            throw new UsernameNotFoundException("user already exist or null");
        }

            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            if (user.getRole() == null) {
                user.setRole(Role.ROLE_USER);

            }
        userRepo.save(user);
        return user;
    }

    public String loginService(LoginRequest loginRequest){

        Users user = userRepo.findByName(loginRequest.name());
        if (user == null){
            throw new UsernameNotFoundException("user doesnt exist");
        }
        if(!passwordEncoder.matches(loginRequest.password(), user.getPassword())){
            throw  new UsernameNotFoundException("password is incorrect");
        }
        return jwtConfig.generateToken(loginRequest.name());
    }


}
