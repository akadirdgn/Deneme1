package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Arac;
import com.rent_a_car.backend.Entity.Musteri;
import com.rent_a_car.backend.Entity.Rezervasyon;
import com.rent_a_car.backend.Repository.RezervasyonRepository;
import com.rent_a_car.backend.Dto.createRequest.CreateRezervasyonRequest;
import com.rent_a_car.backend.Dto.response.RezervasyonResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateRezervasyonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RezervasyonService {

    @Autowired
    private RezervasyonRepository rezervasyonRepository;

    // Tüm rezervasyonları getir
    public List<RezervasyonResponse> getAllRezervasyonlar() {
        List<Rezervasyon> rezervasyonlar = rezervasyonRepository.findAll();
        return rezervasyonlar.stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Rezervasyon ID'sine göre rezervasyon bilgisi getir
    public Optional<RezervasyonResponse> getRezervasyonById(int id) {
        return rezervasyonRepository.findById(id)
                .map(this::convertToResponse);
    }

    // Yeni rezervasyon oluştur
    public RezervasyonResponse createRezervasyon(CreateRezervasyonRequest request) {
        Rezervasyon rezervasyon = new Rezervasyon();
        rezervasyon.setMusteri(new Musteri()); // Burada müşteri nesnesini doldurun
        rezervasyon.setArac(new Arac()); // Burada araç nesnesini doldurun
        rezervasyon.setBaslangicTarihi(request.getBaslangicTarihi());
        rezervasyon.setBitisTarihi(request.getBitisTarihi());
        rezervasyon.setToplamFiyat(request.getToplamFiyat());
        rezervasyon.setDurum(request.getDurum());

        // Rezervasyon nesnesini kaydet
        Rezervasyon savedRezervasyon = rezervasyonRepository.save(rezervasyon);
        return convertToResponse(savedRezervasyon);
    }

    // Rezervasyon güncelle
    public Optional<RezervasyonResponse> updateRezervasyon(int id, UpdateRezervasyonRequest updatedRequest) {
        return rezervasyonRepository.findById(id).map(existingRezervasyon -> {
            existingRezervasyon.setMusteri(new Musteri()); // Burada müşteri nesnesini güncelleyin
            existingRezervasyon.setArac(new Arac()); // Burada araç nesnesini güncelleyin
            existingRezervasyon.setBaslangicTarihi(updatedRequest.getBaslangicTarihi());
            existingRezervasyon.setBitisTarihi(updatedRequest.getBitisTarihi());
            existingRezervasyon.setToplamFiyat(updatedRequest.getToplamFiyat());
            existingRezervasyon.setDurum(updatedRequest.getDurum());

            // Güncellenmiş rezervasyonu kaydet
            Rezervasyon updatedRezervasyon = rezervasyonRepository.save(existingRezervasyon);
            return convertToResponse(updatedRezervasyon);
        });
    }

    // Rezervasyon sil
    public boolean deleteRezervasyon(int id) {
        if (rezervasyonRepository.existsById(id)) {
            rezervasyonRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Entity'den Response DTO'ya dönüşüm metodu
    private RezervasyonResponse convertToResponse(Rezervasyon rezervasyon) {
        RezervasyonResponse response = new RezervasyonResponse();
        response.setId(rezervasyon.getRezervasyonID());
        response.setMusteriId(rezervasyon.getMusteri() != null ? rezervasyon.getMusteri().getMusteriID() : -1); // Müşteri ID null kontrolü
        response.setAracId(rezervasyon.getArac() != null ? rezervasyon.getArac().getAracID() : -1); // Araç ID null kontrolü
        response.setBaslangicTarihi(rezervasyon.getBaslangicTarihi());
        response.setBitisTarihi(rezervasyon.getBitisTarihi());
        response.setToplamFiyat(rezervasyon.getToplamFiyat());
        response.setDurum(rezervasyon.getDurum());
        return response;
    }
}

