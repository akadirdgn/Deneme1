package com.rent_a_car.backend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "rezervasyon")
public class Rezervasyon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rezervasyonID;

    @ManyToOne
    @JoinColumn(name = "musteriID")
    private Musteri musteri;

    @ManyToOne
    @JoinColumn(name = "aracID")
    private Arac arac;

    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    private float toplamFiyat;
    private String durum;

    public Rezervasyon() {
    }

    public int getRezervasyonID() {
        return rezervasyonID;
    }

    public void setRezervasyonID(int rezervasyonID) {
        this.rezervasyonID = rezervasyonID;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
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

    public float getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(float toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
