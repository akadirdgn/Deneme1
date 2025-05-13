package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Admin;
import com.rent_a_car.backend.Repository.AdminRepository;
import com.rent_a_car.backend.Dto.response.AdminResponse;
import com.rent_a_car.backend.Dto.createRequest.CreateAdminRequest;
import com.rent_a_car.backend.Dto.updateRequest.UpdateAdminRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<AdminResponse> getAllAdmin() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(admin -> new AdminResponse(admin.getAdminID(), admin.getAdminAd(), admin.getAdminSoyad()))
                .collect(Collectors.toList());
    }

    public Optional<AdminResponse> getAdminById(int id) {
        return adminRepository.findByAdminID(id)
                .map(admin -> new AdminResponse(admin.getAdminID(), admin.getAdminAd(), admin.getAdminSoyad()));
    }

    public Optional<AdminResponse> login(Admin loginData) {
        return adminRepository.findByAdminAdAndAdminPassword(loginData.getAdminAd(), loginData.getAdminPassword())
                .map(admin -> new AdminResponse(admin.getAdminID(), admin.getAdminAd(), admin.getAdminSoyad()));
    }

    public AdminResponse createAdmin(CreateAdminRequest createAdminRequest) {
        Admin admin = new Admin();
        admin.setAdminAd(createAdminRequest.getAdminAd());
        admin.setAdminSoyad(createAdminRequest.getAdminSoyad());
        admin.setAdminPassword(passwordEncoder.encode(createAdminRequest.getAdminPassword()));

        Admin savedAdmin = adminRepository.save(admin);
        return new AdminResponse(savedAdmin.getAdminID(), savedAdmin.getAdminAd(), savedAdmin.getAdminSoyad());
    }

    public Optional<AdminResponse> updateAdmin(int id, UpdateAdminRequest updateAdminRequest) {
        return adminRepository.findByAdminID(id).map(admin -> {
            admin.setAdminAd(updateAdminRequest.getAdminAd());
            admin.setAdminSoyad(updateAdminRequest.getAdminSoyad());

            if (updateAdminRequest.getAdminPassword() != null && !updateAdminRequest.getAdminPassword().isBlank()) {
                admin.setAdminPassword(passwordEncoder.encode(updateAdminRequest.getAdminPassword()));
            }

            Admin savedAdmin = adminRepository.save(admin);
            return new AdminResponse(savedAdmin.getAdminID(), savedAdmin.getAdminAd(), savedAdmin.getAdminSoyad());
        });
    }

    public boolean deleteAdmin(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

