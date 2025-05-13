package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Entity.Admin;
import com.rent_a_car.backend.Services.AdminService;
import com.rent_a_car.backend.Dto.response.AdminResponse;
import com.rent_a_car.backend.Dto.createRequest.CreateAdminRequest;
import com.rent_a_car.backend.Dto.updateRequest.UpdateAdminRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public ResponseEntity<List<AdminResponse>> getAllAdmin() {
        return ResponseEntity.ok(adminService.getAllAdmin());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> getAdminById(@PathVariable int id) {
        Optional<AdminResponse> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin loginData) {
        return adminService.login(loginData)
                .map(admin -> ResponseEntity.ok("Giriş başarılı!"))
                .orElse(ResponseEntity.status(401).body("Geçersiz kullanıcı adı veya şifre."));
    }

    @PostMapping("/create")
    public ResponseEntity<AdminResponse> createAdmin(@RequestBody CreateAdminRequest createAdminRequest) {
        AdminResponse adminResponse = adminService.createAdmin(createAdminRequest);
        return ResponseEntity.ok(adminResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AdminResponse> updateAdmin(@PathVariable int id, @RequestBody UpdateAdminRequest updateAdminRequest) {
        return adminService.updateAdmin(id, updateAdminRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        if (adminService.deleteAdmin(id)) {
            return ResponseEntity.ok("Admin silindi.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
