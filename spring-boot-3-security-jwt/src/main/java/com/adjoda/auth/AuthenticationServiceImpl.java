package com.adjoda.auth;

import com.adjoda.auth.dto.JwtAuthResponse;
import com.adjoda.auth.dto.SignInRequest;
import com.adjoda.auth.dto.SignUpRequest;
import com.adjoda.auth.exception.UserNotFoundException;
import com.adjoda.auth.exception.UsernameAlreadyExistException;
import com.adjoda.config.jwt.JwtService;
import com.adjoda.user.Role;
import com.adjoda.user.RoleRepository;
import com.adjoda.user.UserEntity;
import com.adjoda.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserEntity signup(SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new UsernameAlreadyExistException();
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(signUpRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        Role roles = roleRepository.findByName("USER").get();
        userEntity.setRoles(Collections.singletonList(roles));

        return userRepository.save(userEntity);
    }

    public JwtAuthResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );
        var user = userRepository.findByUsername(signInRequest.getUsername())
                .orElseThrow(() -> new UserNotFoundException());
        var jwtToken = jwtService.generateToken(user);
        var refreshTokenJwtToken = jwtService.generateRefreshToken(new HashMap<>(),user);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();

        jwtAuthResponse.setJwtToken(jwtToken);
        jwtAuthResponse.setJwtRefreshToken(refreshTokenJwtToken);

        return jwtAuthResponse;
    }
}
