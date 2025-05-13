package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Arac;
import com.rent_a_car.backend.Entity.AracOzellikleri;
import com.rent_a_car.backend.Repository.AracOzellikleriRepository;
import com.rent_a_car.backend.Repository.AracRepository;
import com.rent_a_car.backend.Dto.createRequest.CreateAracOzellikleriRequest;
import com.rent_a_car.backend.Dto.response.AracOzellikleriResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateAracOzellikleriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class AracOzellikleriService {

    @Autowired
    private AracOzellikleriRepository aracOzellikleriRepository;

    @Autowired
    private AracRepository aracRepository;

    public List<AracOzellikleriResponse> getAllAracOzellikleri() {
        return aracOzellikleriRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<AracOzellikleriResponse> getAracOzellikleriByAracID(int id) {
        return aracOzellikleriRepository.findByAracAracID(id).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public Optional<AracOzellikleriResponse> getAracOzellikById(int id) {
        return aracOzellikleriRepository.findById(id).map(this::mapToResponse);
    }

    public ResponseEntity<?> createAracOzellik(CreateAracOzellikleriRequest request) {
        Optional<Arac> arac = aracRepository.findById(request.getAracID());
        if (arac.isEmpty()) {
            return ResponseEntity.badRequest().body("Arac bulunamadı");
        }

        AracOzellikleri ozellik = new AracOzellikleri();
        ozellik.setArac(arac.get());
        ozellik.setOzellikAdi(request.getOzellikAdi());

        AracOzellikleri saved = aracOzellikleriRepository.save(ozellik);
        return ResponseEntity.ok(mapToResponse(saved));
    }

    public ResponseEntity<?> updateAracOzellik(int id, UpdateAracOzellikleriRequest request) {
        Optional<AracOzellikleri> existing = aracOzellikleriRepository.findById(id);
        Optional<Arac> arac = aracRepository.findById(request.getAracID());

        if (existing.isEmpty() || arac.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        AracOzellikleri ozellik = existing.get();
        ozellik.setArac(arac.get());
        ozellik.setOzellikAdi(request.getOzellikAdi());

        AracOzellikleri updated = aracOzellikleriRepository.save(ozellik);
        return ResponseEntity.ok(mapToResponse(updated));
    }

    public boolean deleteAracOzellik(int id) {
        if (aracOzellikleriRepository.existsById(id)) {
            aracOzellikleriRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private AracOzellikleriResponse mapToResponse(AracOzellikleri ozellik) {
        AracOzellikleriResponse dto = new AracOzellikleriResponse();
        dto.setOzellikID(ozellik.getOzellikID());
        dto.setAracID(ozellik.getArac().getAracID());
        dto.setOzellikAdi(ozellik.getOzellikAdi());
        return dto;
    }
}

