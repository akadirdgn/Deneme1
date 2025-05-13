package com.rent_a_car.backend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "odeme")
public class Odeme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int odemeID;

    @OneToOne
    @JoinColumn(name = "rezervasyonid")
    private Rezervasyon rezervasyon;

    private String durum;
    private float tutar;
    private LocalDate odemeTarihi;

    public Odeme() {
    }


    public int getOdemeID() {
        return odemeID;
    }

    public void setOdemeID(int odemeID) {
        this.odemeID = odemeID;
    }

    public Rezervasyon getRezervasyon() {
        return rezervasyon;
    }

    public void setRezervasyon(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }

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
