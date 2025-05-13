package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Musteri;
import com.rent_a_car.backend.Repository.MusteriRepository;
import com.rent_a_car.backend.Security.MusteriDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusteriDetailsService implements UserDetailsService {

    private final MusteriRepository musteriRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Musteri musteri = musteriRepository.findByMusteriEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Müşteri bulunamadı: " + email));
        return new MusteriDetails(musteri);
    }
}



