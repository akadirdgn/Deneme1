package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.AracGorselleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AracGorselleriRepository extends JpaRepository<AracGorselleri, Integer> {
    List<AracGorselleri> findByArac_AracID(int aracID);
}
