package com.adjoda.auth.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
}
