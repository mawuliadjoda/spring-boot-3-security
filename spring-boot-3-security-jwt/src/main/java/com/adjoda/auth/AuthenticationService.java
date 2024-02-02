package com.adjoda.auth;

import com.adjoda.auth.dto.JwtAuthResponse;
import com.adjoda.auth.dto.SignInRequest;
import com.adjoda.auth.dto.SignUpRequest;
import com.adjoda.user.UserEntity;

public interface AuthenticationService {
    UserEntity signup(SignUpRequest signUpRequest);
    JwtAuthResponse signIn(SignInRequest signInRequest);
}
