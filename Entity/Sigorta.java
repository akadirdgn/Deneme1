package com.rent_a_car.backend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "sigorta")
public class Sigorta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sigortaID;

    @OneToOne
    @JoinColumn(name = "aracID")
    private Arac arac;

    private String saglayici;
    private float kapsamTutari;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    private String sigortaDurum;

    public Sigorta() {
    }

    public int getSigortaID() {
        return sigortaID;
    }

    public void setSigortaID(int sigortaID) {
        this.sigortaID = sigortaID;
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public String getSaglayici() {
        return saglayici;
    }

    public void setSaglayici(String saglayici) {
        this.saglayici = saglayici;
    }

    public float getKapsamTutari() {
        return kapsamTutari;
    }

    public void setKapsamTutari(float kapsamTutari) {
        this.kapsamTutari = kapsamTutari;
    }

    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(LocalDate baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public LocalDate getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(LocalDate bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getSigortaDurum() {
        return sigortaDurum;
    }

    public void setSigortaDurum(String sigortaDurum) {
        this.sigortaDurum = sigortaDurum;
    }
}

