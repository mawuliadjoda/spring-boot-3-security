package com.adjoda.auth;

import lombok.Data;

@Data
public class JwtAuthResponse {
    private String jwtToken;
    private String jwtRefreshToken;
}
