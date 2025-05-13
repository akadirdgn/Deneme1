package com.rent_a_car.backend.Security;


import com.rent_a_car.backend.Dto.LoginUser;
import com.rent_a_car.backend.Dto.RegisterUser;
import com.rent_a_car.backend.Entity.Musteri;
import com.rent_a_car.backend.Repository.MusteriRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final MusteriRepository musteriRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            MusteriRepository musteriRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.musteriRepository = musteriRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Musteri signup(RegisterUser input) {
        String[] nameParts = input.getFullName().split(" "); // Ad ve Soyad'ı ayırmak için
        String firstName = nameParts[0];  // İlk adı al
        String lastName = nameParts.length > 1 ? nameParts[1] : "";  // Soyadı al (eğer varsa)

        Musteri user = new Musteri();
        user.setMusteriAdi(firstName);      // İlk adı veritabanına kaydet
        user.setMusteriSoyadi(lastName);   // Soyadı veritabanına kaydet
        user.setMusteriEmail(input.getEmail());
        user.setMusteriSifre(passwordEncoder.encode(input.getPassword())); // Şifreyi encode et

        return musteriRepository.save(user); // Kullanıcıyı kaydet
    }


    public Musteri authenticate(LoginUser input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return musteriRepository.findByMusteriEmail(input.getEmail())
                .orElseThrow();
    }
}