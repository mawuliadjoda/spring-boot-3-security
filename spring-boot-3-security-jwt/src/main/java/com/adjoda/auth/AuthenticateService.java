package com.adjoda.auth;

import com.adjoda.user.UserEntity;

public interface AuthenticateService {
    UserEntity signup(SignUpRequest signUpRequest);
}
