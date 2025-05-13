package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Services.OdemeService;
import com.rent_a_car.backend.Dto.response.OdemeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rent_a_car.backend.Dto.createRequest.CreateOdemeRequest;
import com.rent_a_car.backend.Dto.updateRequest.UpdateOdemeRequest;

import java.util.Optional;

@RestController
@RequestMapping("/api/odemeler")
public class OdemeController {

    @Autowired
    private OdemeService odemeService;

    @GetMapping
    public ResponseEntity<?> getAllOdemeler() {
        return ResponseEntity.ok(odemeService.getAllOdemeler());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOdemeById(@PathVariable int id) {
        return odemeService.getOdemeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createOdeme(@RequestBody CreateOdemeRequest request) {
        Optional<OdemeResponse> created = odemeService.createOdeme(request);
        if (created.isPresent()) {
            return ResponseEntity.ok(created.get());
        } else {
            return ResponseEntity.badRequest().body("Rezervasyon bulunamadı");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateOdeme(@PathVariable int id, @RequestBody UpdateOdemeRequest request) {
        return odemeService.updateOdeme(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOdeme(@PathVariable int id) {
        return odemeService.deleteOdeme(id)
                ? ResponseEntity.ok("Ödeme silindi.")
                : ResponseEntity.notFound().build();
    }
}

