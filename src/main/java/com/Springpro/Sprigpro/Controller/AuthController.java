package com.Springpro.Sprigpro.Controller;


import com.Springpro.Sprigpro.Entity.Users;
import com.Springpro.Sprigpro.LoginRequest;
import com.Springpro.Sprigpro.Repository.UserRepo;
import com.Springpro.Sprigpro.Service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @PostMapping("/addUser")
    public ResponseEntity<Users> registerUser(@RequestBody Users user){
        return ResponseEntity.ok(authService.signUpService(user));

    }

    @PostMapping("/login")
    public  ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest){
        return  ResponseEntity.ok(authService.loginService(loginRequest));
    }
}
