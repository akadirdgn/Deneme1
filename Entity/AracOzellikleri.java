package com.rent_a_car.backend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "arac_ozellikleri")
public class AracOzellikleri implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ozellikID;

    @ManyToOne
    @JoinColumn(name = "aracID")
    private Arac arac;

    private String ozellikAdi;

    public AracOzellikleri() {
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public int getOzellikID() {
        return ozellikID;
    }

    public void setOzellikID(int ozellikID) {
        this.ozellikID = ozellikID;
    }

    public String getOzellikAdi() {
        return ozellikAdi;
    }

    public void setOzellikAdi(String ozellikAdi) {
        this.ozellikAdi = ozellikAdi;
    }
}
