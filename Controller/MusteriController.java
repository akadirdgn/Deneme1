package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Services.MusteriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rent_a_car.backend.Dto.createRequest.CreateMusteriRequest;
import com.rent_a_car.backend.Dto.response.MusteriResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateMusteriRequest;

import java.util.List;

@RestController
@RequestMapping("/api/musteriler")
public class MusteriController {

    @Autowired
    private MusteriService musteriService;

    @GetMapping("/all")
    public ResponseEntity<List<MusteriResponse>> getAllMusteriler() {
        return ResponseEntity.ok(musteriService.getAllMusteriler());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMusteriById(@PathVariable int id) {
        return musteriService.getMusteriById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<MusteriResponse> createMusteri(@RequestBody CreateMusteriRequest request) {
        return new ResponseEntity<>(musteriService.createMusteri(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMusteri(@PathVariable int id, @RequestBody UpdateMusteriRequest request) {
        return musteriService.updateMusteri(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMusteri(@PathVariable int id) {
        return musteriService.deleteMusteri(id)
                ? ResponseEntity.ok("Müşteri silindi.")
                : ResponseEntity.notFound().build();
    }
}

