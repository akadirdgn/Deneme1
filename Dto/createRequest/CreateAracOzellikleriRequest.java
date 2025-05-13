package com.rent_a_car.backend.Dto.createRequest;

public class CreateAracOzellikleriRequest {
    private int aracID;
    private String ozellikAdi;

    // Getters & Setters
    public int getAracID() {
        return aracID;
    }

    public void setAracID(int aracID) {
        this.aracID = aracID;
    }

    public String getOzellikAdi() {
        return ozellikAdi;
    }

    public void setOzellikAdi(String ozellikAdi) {
        this.ozellikAdi = ozellikAdi;
    }
}
