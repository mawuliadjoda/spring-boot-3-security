package com.adjoda.auth;

import com.adjoda.user.UserEntity;

public interface AuthenticationService {
    UserEntity signup(SignUpRequest signUpRequest);
    JwtAuthResponse signIn(SignInRequest signInRequest);
}
