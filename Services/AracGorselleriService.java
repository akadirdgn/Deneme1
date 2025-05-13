package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Arac;
import com.rent_a_car.backend.Entity.AracGorselleri;
import com.rent_a_car.backend.Repository.AracGorselleriRepository;
import com.rent_a_car.backend.Repository.AracRepository;
import com.rent_a_car.backend.Dto.createRequest.CreateAracGorselleriRequest;
import com.rent_a_car.backend.Dto.response.AracGorselleriResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateAracGorselleriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AracGorselleriService {

    @Autowired
    private AracGorselleriRepository aracGorselleriRepository;

    @Autowired
    private AracRepository aracRepository;

    public ResponseEntity<List<AracGorselleriResponse>> getAllAracGorselleri() {
        List<AracGorselleri> gorseller = aracGorselleriRepository.findAll();
        List<AracGorselleriResponse> responseList = gorseller.stream()
                .map(g -> new AracGorselleriResponse(g.getGorselID(), g.getArac().getAracID(), g.getGorselURL()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    public ResponseEntity<List<AracGorselleriResponse>> getAracGorselleriByAracID(int id) {
        List<AracGorselleri> gorseller = aracGorselleriRepository.findByArac_AracID(id);
        List<AracGorselleriResponse> responseList = gorseller.stream()
                .map(g -> new AracGorselleriResponse(g.getGorselID(), g.getArac().getAracID(), g.getGorselURL()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    public ResponseEntity<?> getAracGorselById(int id) {
        Optional<AracGorselleri> gorsel = aracGorselleriRepository.findById(id);
        return gorsel.map(g ->
                ResponseEntity.ok(new AracGorselleriResponse(g.getGorselID(), g.getArac().getAracID(), g.getGorselURL()))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> createAracGorsel(CreateAracGorselleriRequest request) {
        Optional<Arac> arac = aracRepository.findById(request.getAracID());
        if (arac.isEmpty()) {
            return ResponseEntity.badRequest().body("Arac bulunamadı.");
        }

        AracGorselleri gorsel = new AracGorselleri();
        gorsel.setArac(arac.get());
        gorsel.setGorselURL(request.getGorselURL());

        AracGorselleri saved = aracGorselleriRepository.save(gorsel);
        AracGorselleriResponse response = new AracGorselleriResponse(saved.getGorselID(), saved.getArac().getAracID(), saved.getGorselURL());
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> updateAracGorsel(int id, UpdateAracGorselleriRequest request) {
        Optional<AracGorselleri> gorselOptional = aracGorselleriRepository.findById(id);

        if (gorselOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); // Görsel bulunamadı
        }

        AracGorselleri existingGorsel = gorselOptional.get();

        // Eğer yeni bir URL gelmişse, mevcut görselin URL'sini güncelle
        if (request.getGorselURL() != null) {
            existingGorsel.setGorselURL(request.getGorselURL());
        }

        // Güncellenmiş görseli kaydet
        AracGorselleri updatedGorsel = aracGorselleriRepository.save(existingGorsel);

        // Güncellenmiş görselin yanıtını döndür
        AracGorselleriResponse response = new AracGorselleriResponse(
                updatedGorsel.getGorselID(),
                updatedGorsel.getArac().getAracID(),
                updatedGorsel.getGorselURL()
        );

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> deleteAracGorsel(int id) {
        if (!aracGorselleriRepository.existsById(id)) return ResponseEntity.notFound().build();

        aracGorselleriRepository.deleteById(id);
        return ResponseEntity.ok("Görsel silindi.");
    }
}
