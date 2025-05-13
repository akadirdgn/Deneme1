package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.AracOzellikleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AracOzellikleriRepository extends JpaRepository<AracOzellikleri, Integer> {
    List<AracOzellikleri> findByAracAracID(int aracID);
}
