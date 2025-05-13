package com.rent_a_car.backend.Dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;     // ✔️ "email" alanı
    private String password;
}


