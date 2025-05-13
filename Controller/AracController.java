package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Entity.Arac;
import com.rent_a_car.backend.Services.AracService;
import com.rent_a_car.backend.Dto.createRequest.CreateAracRequest;
import com.rent_a_car.backend.Dto.response.AracResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateAracRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/arac")
public class AracController {

    @Autowired
    private AracService aracService;

    @GetMapping("/all")
    public ResponseEntity<List<AracResponse>> getAllAraclar() {
        List<Arac> araclar = aracService.getAllAraclar();
        List<AracResponse> aracResponses = araclar.stream()
                .map(arac -> new AracResponse(
                        arac.getAracID(),
                        arac.getAracAd(),
                        arac.getAracModel(),
                        arac.getAracPlaka(),
                        arac.getAracKiralamaFiyati(),
                        arac.getAracDurum(),
                        arac.getAracAciklama(),
                        arac.isSigortaliMi(),
                        arac.getSonBakimTarihi()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(aracResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AracResponse> getAracById(@PathVariable int id) {
        Optional<Arac> arac = aracService.getAracById(id);
        return arac.map(a -> ResponseEntity.ok(new AracResponse(
                        a.getAracID(),
                        a.getAracAd(),
                        a.getAracModel(),
                        a.getAracPlaka(),
                        a.getAracKiralamaFiyati(),
                        a.getAracDurum(),
                        a.getAracAciklama(),
                        a.isSigortaliMi(),
                        a.getSonBakimTarihi())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<AracResponse> createArac(@RequestBody CreateAracRequest createAracRequest) {
        Arac newArac = aracService.createArac(createAracRequest);
        AracResponse response = new AracResponse(
                newArac.getAracID(),
                newArac.getAracAd(),
                newArac.getAracModel(),
                newArac.getAracPlaka(),
                newArac.getAracKiralamaFiyati(),
                newArac.getAracDurum(),
                newArac.getAracAciklama(),
                newArac.isSigortaliMi(),
                newArac.getSonBakimTarihi());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AracResponse> updateArac(@PathVariable int id, @RequestBody UpdateAracRequest updateAracRequest) {
        Optional<Arac> updatedArac = aracService.updateArac(id, updateAracRequest);
        return updatedArac.map(arac -> ResponseEntity.ok(new AracResponse(
                        arac.getAracID(),
                        arac.getAracAd(),
                        arac.getAracModel(),
                        arac.getAracPlaka(),
                        arac.getAracKiralamaFiyati(),
                        arac.getAracDurum(),
                        arac.getAracAciklama(),
                        arac.isSigortaliMi(),
                        arac.getSonBakimTarihi())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteArac(@PathVariable int id) {
        if (aracService.deleteArac(id)) {
            return ResponseEntity.ok("Araç silindi.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
