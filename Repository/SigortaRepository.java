package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.Sigorta;
import com.rent_a_car.backend.Entity.Arac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SigortaRepository extends JpaRepository<Sigorta, Integer> {
    List<Sigorta> findByArac(Arac arac);

    List<Sigorta> findByBaslangicTarihiBefore(LocalDate tarih);

    List<Sigorta> findByBitisTarihiAfter(LocalDate tarih);

    List<Sigorta> findByBaslangicTarihiBetween(LocalDate startDate, LocalDate endDate);

    List<Sigorta> findBySigortaDurum(String sigortaDurum);
}
