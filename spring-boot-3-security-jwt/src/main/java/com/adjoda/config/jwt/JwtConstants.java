package com.adjoda.config.jwt;

public interface JwtConstants {
    long JWT_TOKEN_EXPIRATION_TIME = 1000 * 60 * 24;
    long JWT_REFRESH_EXPIRATION_TIME = 1000 * 60 * 24 *7;
}
