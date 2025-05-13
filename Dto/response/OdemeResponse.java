package com.rent_a_car.backend.Dto.response;

import java.time.LocalDate;

public class OdemeResponse {
    private int odemeID;
    private int rezervasyonID;
    private String durum;
    private float tutar;
    private LocalDate odemeTarihi;

    public OdemeResponse(int odemeID, int rezervasyonID, String durum, float tutar, LocalDate odemeTarihi) {
        this.odemeID = odemeID;
        this.rezervasyonID = rezervasyonID;
        this.durum = durum;
        this.tutar = tutar;
        this.odemeTarihi = odemeTarihi;
    }

    public int getOdemeID() {
        return odemeID;
    }

    public void setOdemeID(int odemeID) {
        this.odemeID = odemeID;
    }

    public int getRezervasyonID() {
        return rezervasyonID;
    }

    public void setRezervasyonID(int rezervasyonID) {
        this.rezervasyonID = rezervasyonID;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public float getTutar() {
        return tutar;
    }

    public void setTutar(float tutar) {
        this.tutar = tutar;
    }

    public LocalDate getOdemeTarihi() {
        return odemeTarihi;
    }

    public void setOdemeTarihi(LocalDate odemeTarihi) {
        this.odemeTarihi = odemeTarihi;
    }
}

