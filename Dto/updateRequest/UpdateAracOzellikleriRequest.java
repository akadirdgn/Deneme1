package com.rent_a_car.backend.Dto.updateRequest;

public class UpdateAracOzellikleriRequest {
    private int aracID;
    private String ozellikAdi;

    public int getAracID() {
        return aracID;
    }

    public void setAracID(int aracID) {
        this.aracID = aracID;
    }

    public String getOzellikAdi() {
        return ozellikAdi;
    }
}

