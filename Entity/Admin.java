package com.rent_a_car.backend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminID;

    private String adminAd;
    private String adminSoyad;
    private String adminEmail;

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    private String adminPassword;

    public Admin() {
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminAd() {
        return adminAd;
    }

    public void setAdminAd(String adminAd) {
        this.adminAd = adminAd;
    }

    public String getAdminSoyad() {
        return adminSoyad;
    }

    public void setAdminSoyad(String adminSoyad) {
        this.adminSoyad = adminSoyad;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
