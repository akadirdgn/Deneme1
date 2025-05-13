package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.Rezervasyon;
import com.rent_a_car.backend.Entity.Musteri;
import com.rent_a_car.backend.Entity.Arac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RezervasyonRepository extends JpaRepository<Rezervasyon, Integer> {
    List<Rezervasyon> findByMusteri(Musteri musteri);

    List<Rezervasyon> findByArac(Arac arac);

    List<Rezervasyon> findByBaslangicTarihiAfter(LocalDate tarih);

    List<Rezervasyon> findByBitisTarihiBefore(LocalDate tarih);

    List<Rezervasyon> findByBaslangicTarihiBetween(LocalDate startDate, LocalDate endDate);

    List<Rezervasyon> findByDurum(String durum);
}
