package com.rent_a_car.backend.Repository;

import com.rent_a_car.backend.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByAdminID(int AdminID);

    Optional<Admin> findByAdminEmail(String adminEmail);

    Optional<Admin> findByAdminAdAndAdminPassword(String adminAd, String adminPassword);
}
