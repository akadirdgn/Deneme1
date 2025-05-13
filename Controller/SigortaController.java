package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Services.SigortaService;
import com.rent_a_car.backend.Dto.createRequest.CreateSigortaRequest;
import com.rent_a_car.backend.Dto.response.SigortaResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateSigortaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sigortalar")
public class SigortaController {

    @Autowired
    private SigortaService sigortaService;

    @GetMapping
    public ResponseEntity<List<SigortaResponse>> getAllSigortalar() {
        List<SigortaResponse> sigortalar = sigortaService.getAllSigortalar();
        return sigortalar.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(sigortalar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SigortaResponse> getSigortaById(@PathVariable int id) {
        SigortaResponse response = sigortaService.getSigortaById(id);
        return response != null ?
                ResponseEntity.ok(response) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<SigortaResponse> createSigorta(@RequestBody CreateSigortaRequest request) {
        SigortaResponse created = sigortaService.createSigorta(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SigortaResponse> updateSigorta(
            @PathVariable int id,
            @RequestBody UpdateSigortaRequest request) {
        SigortaResponse updated = sigortaService.updateSigorta(id, request);
        return updated != null ?
                ResponseEntity.ok(updated) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSigorta(@PathVariable int id) {
        boolean deleted = sigortaService.deleteSigorta(id);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
