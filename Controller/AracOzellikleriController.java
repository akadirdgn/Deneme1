package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Services.AracOzellikleriService;
import com.rent_a_car.backend.Dto.createRequest.CreateAracOzellikleriRequest;
import com.rent_a_car.backend.Dto.response.AracOzellikleriResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateAracOzellikleriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/arac-ozellikleri")
public class AracOzellikleriController {

    @Autowired
    private AracOzellikleriService aracOzellikleriService;

    @GetMapping("/all")
    public ResponseEntity<List<AracOzellikleriResponse>> getAllAracOzellikleri() {
        return ResponseEntity.ok(aracOzellikleriService.getAllAracOzellikleri());
    }

    @GetMapping("/arac/{id}")
    public ResponseEntity<List<AracOzellikleriResponse>> getAracOzellikleriByAracID(@PathVariable int id) {
        return ResponseEntity.ok(aracOzellikleriService.getAracOzellikleriByAracID(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAracOzellikById(@PathVariable int id) {
        Optional<AracOzellikleriResponse> response = aracOzellikleriService.getAracOzellikById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAracOzellik(@RequestBody CreateAracOzellikleriRequest request) {
        return aracOzellikleriService.createAracOzellik(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAracOzellik(@PathVariable int id, @RequestBody UpdateAracOzellikleriRequest request) {
        return aracOzellikleriService.updateAracOzellik(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAracOzellik(@PathVariable int id) {
        boolean result = aracOzellikleriService.deleteAracOzellik(id);
        return result ? ResponseEntity.ok("Araç özelliği silindi.") : ResponseEntity.notFound().build();
    }
}

