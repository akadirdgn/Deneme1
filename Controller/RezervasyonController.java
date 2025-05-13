package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Services.RezervasyonService;
import com.rent_a_car.backend.Dto.createRequest.CreateRezervasyonRequest;
import com.rent_a_car.backend.Dto.response.RezervasyonResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateRezervasyonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rezervasyonlar")
public class RezervasyonController {

    @Autowired
    private RezervasyonService rezervasyonService;

    @GetMapping("/all")
    public ResponseEntity<List<RezervasyonResponse>> getAllRezervasyonlar() {
        return ResponseEntity.ok(rezervasyonService.getAllRezervasyonlar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RezervasyonResponse> getRezervasyonById(@PathVariable int id) {
        return rezervasyonService.getRezervasyonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<RezervasyonResponse> createRezervasyon(@RequestBody CreateRezervasyonRequest request) {
        return new ResponseEntity<>(rezervasyonService.createRezervasyon(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RezervasyonResponse> updateRezervasyon(@PathVariable int id, @RequestBody UpdateRezervasyonRequest request) {
        return rezervasyonService.updateRezervasyon(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRezervasyon(@PathVariable int id) {
        return rezervasyonService.deleteRezervasyon(id)
                ? ResponseEntity.ok("Rezervasyon silindi.")
                : ResponseEntity.notFound().build();
    }
}
