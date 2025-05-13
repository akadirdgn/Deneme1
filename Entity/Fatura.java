package com.rent_a_car.backend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "fatura")
public class Fatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int faturaID;

    @OneToOne
    @JoinColumn(name = "odemeID")
    private Odeme odeme;

    private float toplamTutar;
    private LocalDate duzenlenmeTarihi;

    public Fatura() {
    }

    public int getFaturaID() {
        return faturaID;
    }

    public void setFaturaID(int faturaID) {
        this.faturaID = faturaID;
    }

    public Odeme getOdeme() {
        return odeme;
    }

    public void setOdeme(Odeme odeme) {
        this.odeme = odeme;
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
}
