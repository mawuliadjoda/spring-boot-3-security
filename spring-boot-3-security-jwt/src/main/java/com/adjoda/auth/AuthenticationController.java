package com.adjoda.auth;

import com.adjoda.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticateService authenticateService;

    @PostMapping("signup")
    public ResponseEntity<UserEntity> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticateService.signup(signUpRequest));
    }
}
