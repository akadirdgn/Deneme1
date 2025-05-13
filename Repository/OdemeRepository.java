package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.Odeme;
import com.rent_a_car.backend.Entity.Rezervasyon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OdemeRepository extends JpaRepository<Odeme, Integer> {
    Optional<Odeme> findByRezervasyon(Rezervasyon rezervasyon);

    List<Odeme> findByDurum(String durum);

    List<Odeme> findByOdemeTarihiBetween(LocalDate startDate, LocalDate endDate);

    Optional<Odeme> findByRezervasyonAndDurum(Rezervasyon rezervasyon, String durum);
}
