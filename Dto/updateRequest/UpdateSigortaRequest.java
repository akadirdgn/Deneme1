package com.rent_a_car.backend.Dto.updateRequest;

import java.time.LocalDate;

public class UpdateSigortaRequest {

    private String saglayici;
    private float kapsamTutari;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    private String sigortaDurum;

    // Getter ve Setter metodları
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
