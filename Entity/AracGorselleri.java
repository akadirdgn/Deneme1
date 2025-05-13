package com.rent_a_car.backend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "arac_gorselleri")
public class AracGorselleri implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gorselID;

    @ManyToOne
    @JoinColumn(name = "aracID")
    private Arac arac;

    private String gorselURL;

    public AracGorselleri() {
    }

    public int getGorselID() {
        return gorselID;
    }

    public void setGorselID(int gorselID) {
        this.gorselID = gorselID;
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public String getGorselURL() {
        return gorselURL;
    }

    public void setGorselURL(String gorselURL) {
        this.gorselURL = gorselURL;
    }
}
