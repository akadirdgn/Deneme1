package com.rent_a_car.backend.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "musteri")
public class Musteri implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int musteriID;

    private String musteriAdi;
    private String musteriSoyadi;
    private String musteriTelefon;
    private String musteriEmail;
    private String musteriSifre;
    private String musteriOdemeYontemi;

    public Musteri() {
    }

    public int getMusteriID() {
        return musteriID;
    }

    public void setMusteriID(int musteriID) {
        this.musteriID = musteriID;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    public void setMusteriSoyadi(String musteriSoyadi) {
        this.musteriSoyadi = musteriSoyadi;
    }

    public String getMusteriTelefon() {
        return musteriTelefon;
    }

    public void setMusteriTelefon(String musteriTelefon) {
        this.musteriTelefon = musteriTelefon;
    }

    public String getMusteriEmail() {
        return musteriEmail;
    }

    public void setMusteriEmail(String musteriEmail) {
        this.musteriEmail = musteriEmail;
    }

    public String getMusteriSifre() {
        return musteriSifre;
    }

    public void setMusteriSifre(String musteriSifre) {
        this.musteriSifre = musteriSifre;
    }

    public String getMusteriOdemeYontemi() {
        return musteriOdemeYontemi;
    }

    public void setMusteriOdemeYontemi(String musteriOdemeYontemi) {
        this.musteriOdemeYontemi = musteriOdemeYontemi;
    }

    // UserDetails metotları
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Kullanıcıya atanmış roller burada döndürülebilir. Örneğin "ROLE_USER"
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return musteriSifre; // Kullanıcının şifresi
    }

    @Override
    public String getUsername() {
        return musteriEmail; // Kullanıcının email adresi username olarak alınıyor
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Hesap süresi dolmuşsa false döndürülebilir
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Hesap kilitli değilse true döndürülür
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Şifre süresi dolmuşsa false döndürülebilir
    }

    @Override
    public boolean isEnabled() {
        return true; // Kullanıcı aktifse true döndürülür
    }
}

