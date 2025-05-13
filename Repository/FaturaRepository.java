package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.Fatura;
import com.rent_a_car.backend.Entity.Rezervasyon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {
    List<Fatura> findByOdeme_Rezervasyon_Musteri_MusteriID(int musteriID);

    Fatura findByOdeme_Rezervasyon_RezervasyonID(int rezervasyonID);

    List<Fatura> findByOdeme_Durum(String durum);

    List<Fatura> findByOdeme_Rezervasyon(Rezervasyon rezervasyon);
}
