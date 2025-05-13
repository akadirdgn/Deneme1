package com.rent_a_car.backend.Security;

import com.rent_a_car.backend.Entity.Musteri;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MusteriDetails implements UserDetails {

    private final Musteri musteri;

    public MusteriDetails(Musteri musteri) {
        this.musteri = musteri;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_MUSTERI"));
    }

    @Override
    public String getPassword() {
        return musteri.getMusteriSifre();
    }

    @Override
    public String getUsername() {
        return musteri.getMusteriEmail();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    public Musteri getMusteri() {
        return musteri;
    }
}


