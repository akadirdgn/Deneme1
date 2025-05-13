package com.rent_a_car.backend.Dto.response;

import java.time.LocalDate;

public class AracResponse {
    private int aracID;
    private String aracAd;
    private String aracModel;
    private String aracPlaka;
    private float aracKiralamaFiyati;
    private String aracDurum;
    private String aracAciklama;
    private boolean sigortaliMi;
    private LocalDate sonBakimTarihi;

    public AracResponse(int aracID, String aracAd, String aracModel, String aracPlaka,
                        float aracKiralamaFiyati, String aracDurum, String aracAciklama,
                        boolean sigortaliMi, LocalDate sonBakimTarihi) {
        this.aracID = aracID;
        this.aracAd = aracAd;
        this.aracModel = aracModel;
        this.aracPlaka = aracPlaka;
        this.aracKiralamaFiyati = aracKiralamaFiyati;
        this.aracDurum = aracDurum;
        this.aracAciklama = aracAciklama;
        this.sigortaliMi = sigortaliMi;
        this.sonBakimTarihi = sonBakimTarihi;
    }

    public int getAracID() {
        return aracID;
    }

    public void setAracID(int aracID) {
        this.aracID = aracID;
    }

    public String getAracAd() {
        return aracAd;
    }

    public void setAracAd(String aracAd) {
        this.aracAd = aracAd;
    }

    public String getAracModel() {
        return aracModel;
    }

    public void setAracModel(String aracModel) {
        this.aracModel = aracModel;
    }

    public String getAracPlaka() {
        return aracPlaka;
    }

    public void setAracPlaka(String aracPlaka) {
        this.aracPlaka = aracPlaka;
    }

    public float getAracKiralamaFiyati() {
        return aracKiralamaFiyati;
    }

    public void setAracKiralamaFiyati(float aracKiralamaFiyati) {
        this.aracKiralamaFiyati = aracKiralamaFiyati;
    }

    public String getAracDurum() {
        return aracDurum;
    }

    public void setAracDurum(String aracDurum) {
        this.aracDurum = aracDurum;
    }

    public String getAracAciklama() {
        return aracAciklama;
    }

    public void setAracAciklama(String aracAciklama) {
        this.aracAciklama = aracAciklama;
    }

    public boolean isSigortaliMi() {
        return sigortaliMi;
    }

    public void setSigortaliMi(boolean sigortaliMi) {
        this.sigortaliMi = sigortaliMi;
    }

    public LocalDate getSonBakimTarihi() {
        return sonBakimTarihi;
    }

    public void setSonBakimTarihi(LocalDate sonBakimTarihi) {
        this.sonBakimTarihi = sonBakimTarihi;
    }
}

