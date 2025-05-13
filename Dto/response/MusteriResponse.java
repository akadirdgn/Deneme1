package com.rent_a_car.backend.Dto.response;

public class MusteriResponse {
    private int musteriID;
    private String musteriAdi;
    private String musteriSoyadi;
    private String musteriTelefon;
    private String musteriEposta;
    private String musteriOdemeYontemi;

    public MusteriResponse(int musteriID, String musteriAdi, String musteriSoyadi,
                           String musteriTelefon, String musteriEposta, String musteriOdemeYontemi) {
        this.musteriID = musteriID;
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
        this.musteriTelefon = musteriTelefon;
        this.musteriEposta = musteriEposta;
        this.musteriOdemeYontemi = musteriOdemeYontemi;
    }

    public MusteriResponse() {

    }

    public int getMusteriID() {
        return musteriID;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    public String getMusteriTelefon() {
        return musteriTelefon;
    }

    public String getMusteriEposta() {
        return musteriEposta;
    }

    public String getMusteriOdemeYontemi() {
        return musteriOdemeYontemi;
    }
}

