package com.qp.assesment.controller;

import com.qp.assesment.exceptions.ApiException;
import com.qp.assesment.model.request.AuthRequest;
import com.qp.assesment.model.request.AuthResponse;
import com.qp.assesment.model.UserModel;
import com.qp.assesment.service.Impl.UserDetailsServiceImpl;
import com.qp.assesment.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody AuthRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword());
        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new ApiException("Invalid username or password");
        }
        String token = jwtService.GenerateToken(userDetailsService.loadUserByUsername(request.getUsername()).getUsername());
        return AuthResponse.builder().token(token).build();
    }

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody UserModel userModel) {

    }

}
