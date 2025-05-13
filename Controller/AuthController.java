package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Dto.AuthRequest;
import com.rent_a_car.backend.Dto.AuthResponse;
import com.rent_a_car.backend.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login-admin")
    public ResponseEntity<AuthResponse> loginAdmin(@RequestBody AuthRequest dto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );

        // Rol kontrolü ekleniyor
        if (!auth.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
            throw new AccessDeniedException("Admin yetkisi gerekiyor");
        }

        String token = jwtTokenProvider.generateToken(dto.getEmail(), "ROLE_ADMIN");
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login-musteri")
    public ResponseEntity<AuthResponse> loginMusteri(@RequestBody AuthRequest dto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );

        String token = jwtTokenProvider.generateToken(dto.getEmail(), "ROLE_MUSTERI");
        return ResponseEntity.ok(new AuthResponse(token));
    }
}


