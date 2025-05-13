package com.rent_a_car.backend.Dto.response;

public class AracGorselleriResponse {
    private int gorselID;
    private int aracID;
    private String gorselURL;

    public AracGorselleriResponse(int gorselID, int aracID, String gorselURL) {
        this.gorselID = gorselID;
        this.aracID = aracID;
        this.gorselURL = gorselURL;
    }

    public int getGorselID() {
        return gorselID;
    }

    public int getAracID() {
        return aracID;
    }

    public String getGorselURL() {
        return gorselURL;
    }
}
