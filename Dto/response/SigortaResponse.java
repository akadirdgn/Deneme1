package com.rent_a_car.backend.Dto.response;

import java.time.LocalDate;

public class SigortaResponse {
    private int sigortaID;
    private int aracID;
    private String saglayici;
    private float kapsamTutari;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    private String sigortaDurum;

    public int getSigortaID() {
        return sigortaID;
    }

    public void setSigortaID(int sigortaID) {
        this.sigortaID = sigortaID;
    }

    public int getAracID() {
        return aracID;
    }

    public void setAracID(int aracID) {
        this.aracID = aracID;
    }

    public String getSaglayici() {
        return saglayici;
    }

    public void setSaglayici(String saglayici) {
        this.saglayici = saglayici;
    }

    public float getKapsamTutari() {
        return kapsamTutari;
    }

    public void setKapsamTutari(float kapsamTutari) {
        this.kapsamTutari = kapsamTutari;
    }

    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(LocalDate baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public LocalDate getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(LocalDate bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getSigortaDurum() {
        return sigortaDurum;
    }

    public void setSigortaDurum(String sigortaDurum) {
        this.sigortaDurum = sigortaDurum;
    }
}
