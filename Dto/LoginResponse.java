package com.rent_a_car.backend.Dto;

public class LoginResponse {
    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }

}