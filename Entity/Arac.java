package com.rent_a_car.backend.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "arac")
public class Arac implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aracID;

    private String aracAd;
    private String aracModel;
    private String aracPlaka;
    private float aracKiralamaFiyati;
    private String aracDurum;
    private String aracAciklama;
    private boolean sigortaliMi;
    private LocalDate sonBakimTarihi;

    public Arac() {
    }

    public int getAracID() {
        return aracID;
    }

    public void setAracID(int aracID) {
        this.aracID = aracID;
    }

    public String getAracModel() {
        return aracModel;
    }

    public void setAracModel(String aracModel) {
        this.aracModel = aracModel;
    }

    public String getAracAd() {
        return aracAd;
    }

    public void setAracAd(String aracAd) {
        this.aracAd = aracAd;
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

    public LocalDate getSonBakimTarihi() {
        return sonBakimTarihi;
    }

    public void setSonBakimTarihi(LocalDate sonBakimTarihi) {
        this.sonBakimTarihi = sonBakimTarihi;
    }

    public boolean isSigortaliMi() {
        return sigortaliMi;
    }

    public void setSigortaliMi(boolean sigortaliMi) {
        this.sigortaliMi = sigortaliMi;
    }

    public String getAracAciklama() {
        return aracAciklama;
    }

    public void setAracAciklama(String aracAciklama) {
        this.aracAciklama = aracAciklama;
    }

    public String getAracDurum() {
        return aracDurum;
    }

    public void setAracDurum(String aracDurum) {
        this.aracDurum = aracDurum;
    }
}
