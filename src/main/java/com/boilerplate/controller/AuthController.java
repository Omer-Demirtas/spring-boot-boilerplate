package com.boilerplate.controller;

import com.boilerplate.domain.Authority;
import com.boilerplate.domain.User;
import com.boilerplate.dto.AuthResponse;
import com.boilerplate.dto.UserDTO;
import com.boilerplate.repository.AuthorityRepository;
import com.boilerplate.repository.UserRepository;
import com.boilerplate.security.JwtTokenProvider;
import com.boilerplate.service.RefreshTokenService;
import com.boilerplate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final RefreshTokenService refreshTokenService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO loginRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        return jwtTokenProvider.generateJwtToken(auth);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO registerRequest) {
        if(userService.getOneUserByUserName(registerRequest.getUserName()) != null) {
            return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user = userRepository.save(user);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(registerRequest.getUserName(), registerRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return ResponseEntity.ok(jwtTokenProvider.generateJwtToken(auth));

    }

    @GetMapping("/hello")
    public List<User> getMessage() {
        return userRepository.findAll();
    }


}
