package com.adjoda.auth;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
}
