package com.rent_a_car.backend.Dto.response;

import java.time.LocalDate;

public class FaturaResponse {
    private int faturaID;
    private float toplamTutar;
    private LocalDate duzenlenmeTarihi;
    private int odemeID;

    public int getFaturaID() {
        return faturaID;
    }

    public void setFaturaID(int faturaID) {
        this.faturaID = faturaID;
    }

    public float getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(float toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public LocalDate getDuzenlenmeTarihi() {
        return duzenlenmeTarihi;
    }

    public void setDuzenlenmeTarihi(LocalDate duzenlenmeTarihi) {
        this.duzenlenmeTarihi = duzenlenmeTarihi;
    }

    public int getOdemeID() {
        return odemeID;
    }

    public void setOdemeID(int odemeID) {
        this.odemeID = odemeID;
    }
}


