package com.rent_a_car.backend.Dto.createRequest;


public class CreateAracGorselleriRequest {
    private int aracID;
    private String gorselURL;

    public int getAracID() {
        return aracID;
    }

    public void setAracID(int aracID) {
        this.aracID = aracID;
    }

    public String getGorselURL() {
        return gorselURL;
    }

    public void setGorselURL(String gorselURL) {
        this.gorselURL = gorselURL;
    }
}
