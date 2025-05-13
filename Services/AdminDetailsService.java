package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Admin;
import com.rent_a_car.backend.Repository.AdminRepository;
import com.rent_a_car.backend.Security.AdminDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByAdminEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin bulunamadı: " + email));
        return new AdminDetails(admin);
    }
}


