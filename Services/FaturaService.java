package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Fatura;
import com.rent_a_car.backend.Entity.Odeme;
import com.rent_a_car.backend.Repository.FaturaRepository;
import com.rent_a_car.backend.Repository.OdemeRepository;
import com.rent_a_car.backend.Dto.createRequest.CreateFaturaRequest;
import com.rent_a_car.backend.Dto.response.FaturaResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateFaturaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class FaturaService {

    @Autowired
    private FaturaRepository faturaRepository;

    @Autowired
    private OdemeRepository odemeRepository;

    public List<FaturaResponse> getAllFatura() {
        List<Fatura> faturalar = faturaRepository.findAll();
        return faturalar.stream().map(this::convertToFaturaResponse).collect(Collectors.toList());
    }

    public Optional<FaturaResponse> getFaturaById(int id) {
        return faturaRepository.findById(id).map(this::convertToFaturaResponse);
    }

    public ResponseEntity<FaturaResponse> createFatura(CreateFaturaRequest request) {
        Optional<Odeme> odemeOptional = odemeRepository.findById(request.getOdemeID());

        if (odemeOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Fatura fatura = new Fatura();
        fatura.setToplamTutar(request.getToplamTutar());
        fatura.setDuzenlenmeTarihi(request.getDuzenlenmeTarihi());
        fatura.setOdeme(odemeOptional.get());

        Fatura savedFatura = faturaRepository.save(fatura);

        FaturaResponse response = convertToFaturaResponse(savedFatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<FaturaResponse> updateFatura(int id, UpdateFaturaRequest request) {
        Optional<Fatura> faturaOptional = faturaRepository.findById(id);

        if (faturaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Mevcut faturayı alıyoruz
        Fatura existingFatura = faturaOptional.get();

        // Ödeme ID'sine göre ödeme nesnesini bulalım
        Optional<Odeme> odemeOptional = odemeRepository.findById(request.getOdemeID());

        if (odemeOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Fatura güncelleniyor
        existingFatura.setToplamTutar(request.getToplamTutar());
        existingFatura.setDuzenlenmeTarihi(request.getDuzenlenmeTarihi());
        existingFatura.setOdeme(odemeOptional.get());

        // Güncellenen faturayı kaydediyoruz
        Fatura updatedFatura = faturaRepository.save(existingFatura);

        // Response DTO'yu oluşturuyoruz
        FaturaResponse response = convertToFaturaResponse(updatedFatura);
        return ResponseEntity.ok(response);
    }

    public boolean deleteFatura(int id) {
        if (faturaRepository.existsById(id)) {
            faturaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Fatura nesnesini FaturaResponse DTO'ya dönüştürme
    private FaturaResponse convertToFaturaResponse(Fatura fatura) {
        FaturaResponse response = new FaturaResponse();
        response.setFaturaID(fatura.getFaturaID());
        response.setToplamTutar(fatura.getToplamTutar());
        response.setDuzenlenmeTarihi(fatura.getDuzenlenmeTarihi());
        response.setOdemeID(fatura.getOdeme().getOdemeID());
        return response;
    }
}

