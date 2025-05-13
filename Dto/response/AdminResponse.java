package com.rent_a_car.backend.Dto.response;

public class AdminResponse {
    private int adminID;
    private String adminAd;
    private String adminSoyad;

    public AdminResponse(int adminID, String adminAd, String adminSoyad) {
        this.adminID = adminID;
        this.adminAd = adminAd;
        this.adminSoyad = adminSoyad;
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
}
