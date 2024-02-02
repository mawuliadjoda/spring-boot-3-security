package com.adjoda.auth.dto;

import lombok.Data;

@Data
public class JwtAuthResponse {
    private String jwtToken;
    private String jwtRefreshToken;
}
