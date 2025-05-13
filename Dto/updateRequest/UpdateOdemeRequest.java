package com.rent_a_car.backend.Dto.updateRequest;

import java.time.LocalDate;

public class UpdateOdemeRequest {
    private String durum;
    private float tutar;
    private LocalDate odemeTarihi;

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public float getTutar() {
        return tutar;
    }

    public void setTutar(float tutar) {
        this.tutar = tutar;
    }

    public LocalDate getOdemeTarihi() {
        return odemeTarihi;
    }

    public void setOdemeTarihi(LocalDate odemeTarihi) {
        this.odemeTarihi = odemeTarihi;
    }
}
