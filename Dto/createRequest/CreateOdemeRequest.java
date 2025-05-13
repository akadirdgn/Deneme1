package com.rent_a_car.backend.Dto.createRequest;

import java.time.LocalDate;

public class CreateOdemeRequest {
    private int rezervasyonId;
    private String durum;
    private float tutar;
    private LocalDate odemeTarihi;

    public int getRezervasyonId() {
        return rezervasyonId;
    }

    public String getDurum() {
        return durum;
    }

    public float getTutar() {
        return tutar;
    }

    public LocalDate getOdemeTarihi() {
        return odemeTarihi;
    }
}
