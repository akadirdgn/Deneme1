package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.Arac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AracRepository extends JpaRepository<Arac, Integer> {
    List<Arac> findByAracAd(String aracAd);

    List<Arac> findByAracModel(String AracModel);

    Arac findByAracPlaka(String AracPlaka);
}
