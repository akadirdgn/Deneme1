package com.rent_a_car.backend.Dto.createRequest;

import java.time.LocalDate;

public class CreateAracRequest {
    private String aracAd;
    private String aracModel;
    private String aracPlaka;
    private float aracKiralamaFiyati;
    private String aracDurum;
    private String aracAciklama;
    private boolean sigortaliMi;
    private LocalDate sonBakimTarihi;

    public String getAracAd() {
        return aracAd;
    }

    public String getAracModel() {
        return aracModel;
    }

    public String getAracPlaka() {
        return aracPlaka;
    }

    public float getAracKiralamaFiyati() {
        return aracKiralamaFiyati;
    }

    public String getAracDurum() {
        return aracDurum;
    }

    public String getAracAciklama() {
        return aracAciklama;
    }

    public boolean isSigortaliMi() {
        return sigortaliMi;
    }

    public LocalDate getSonBakimTarihi() {
        return sonBakimTarihi;
    }
}

