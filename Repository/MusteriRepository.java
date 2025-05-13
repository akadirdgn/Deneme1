package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri, Integer> {
    Optional<Musteri> findByMusteriEmail(String email);
}

