package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Services.FaturaService;
import com.rent_a_car.backend.Dto.createRequest.CreateFaturaRequest;
import com.rent_a_car.backend.Dto.response.FaturaResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateFaturaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faturalar")
public class FaturaController {

    @Autowired
    private FaturaService faturaService;

    @GetMapping("/all")
    public ResponseEntity<List<FaturaResponse>> getAllFatura() {
        return ResponseEntity.ok(faturaService.getAllFatura());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaturaResponse> getFaturaById(@PathVariable int id) {
        Optional<FaturaResponse> response = faturaService.getFaturaById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<FaturaResponse> createFatura(@RequestBody CreateFaturaRequest request) {
        return faturaService.createFatura(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FaturaResponse> updateFatura(@PathVariable int id, @RequestBody UpdateFaturaRequest request) {
        return faturaService.updateFatura(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFatura(@PathVariable int id) {
        boolean result = faturaService.deleteFatura(id);
        return result ? ResponseEntity.ok("Fatura silindi.") : ResponseEntity.notFound().build();
    }
}
