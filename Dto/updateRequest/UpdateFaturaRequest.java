package com.rent_a_car.backend.Dto.updateRequest;

import java.time.LocalDate;

public class UpdateFaturaRequest {
    private int odemeID;
    private float toplamTutar;
    private LocalDate duzenlenmeTarihi;

    public int getOdemeID() {
        return odemeID;
    }
    public float getToplamTutar() {
        return toplamTutar;
    }

    public LocalDate getDuzenlenmeTarihi() {
        return duzenlenmeTarihi;
    }
}

