package com.rent_a_car.backend.Dto.response;

public class AracOzellikleriResponse {
    private int ozellikID;
    private int aracID;
    private String ozellikAdi;

    public int getOzellikID() {
        return ozellikID;
    }

    public void setOzellikID(int ozellikID) {
        this.ozellikID = ozellikID;
    }

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

