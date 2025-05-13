package com.rent_a_car.backend.Dto.createRequest;

import java.time.LocalDate;

public class CreateSigortaRequest {

    private int aracID;
    private String saglayici;
    private float kapsamTutari;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    private String sigortaDurum;

    public int getAracID() {
        return aracID;
    }

    public void setAracID(int aracID) {
        this.aracID = aracID;
    }

    public String getSaglayici() {
        return saglayici;
    }

    public float getKapsamTutari() {
        return kapsamTutari;
    }

    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public LocalDate getBitisTarihi() {
        return bitisTarihi;
    }

    public String getSigortaDurum() {
        return sigortaDurum;
    }

}
