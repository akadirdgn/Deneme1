package com.rent_a_car.backend.Dto.createRequest;

import java.time.LocalDate;

public class CreateRezervasyonRequest {

    private int musteriId;
    private int aracId;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    private float toplamFiyat;
    private String durum;

    public int getMusteriId() {
        return musteriId;
    }

    public int getAracId() {
        return aracId;
    }

    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public LocalDate getBitisTarihi() {
        return bitisTarihi;
    }

    public float getToplamFiyat() {
        return toplamFiyat;
    }

    public String getDurum() {
        return durum;
    }
}
