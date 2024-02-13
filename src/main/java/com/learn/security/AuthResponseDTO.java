package com.learn.security;

public class AuthResponseDTO {
    private final String accessToken;
    private String tokenType;

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return this.accessToken;
    }
}
