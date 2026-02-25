package com.Springpro.Sprigpro.Service;

import com.Springpro.Sprigpro.Entity.Users;
import com.Springpro.Sprigpro.LoginRequest;


public interface AuthService {
    Users signUpService(Users user);
    String loginService(LoginRequest loginRequest);
}
