package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Musteri;
import com.rent_a_car.backend.Repository.MusteriRepository;
import com.rent_a_car.backend.Dto.createRequest.CreateMusteriRequest;
import com.rent_a_car.backend.Dto.response.MusteriResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateMusteriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusteriService {

    @Autowired
    private MusteriRepository musteriRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<MusteriResponse> getAllMusteriler() {
        return musteriRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public Optional<MusteriResponse> getMusteriById(int id) {
        return musteriRepository.findById(id).map(this::mapToResponse);
    }

    public boolean deleteMusteri(int id) {
        if (musteriRepository.existsById(id)) {
            musteriRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public MusteriResponse createMusteri(CreateMusteriRequest request) {
        Musteri musteri = new Musteri();
        musteri.setMusteriAdi(request.getMusteriAdi());
        musteri.setMusteriSoyadi(request.getMusteriSoyadi());
        musteri.setMusteriTelefon(request.getMusteriTelefon());
        musteri.setMusteriEmail(request.getMusteriEposta());
        musteri.setMusteriSifre(passwordEncoder.encode(request.getMusteriSifre()));;
        musteri.setMusteriOdemeYontemi(request.getMusteriOdemeYontemi());

        return mapToResponse(musteriRepository.save(musteri));
    }

    public Optional<MusteriResponse> updateMusteri(int id, UpdateMusteriRequest request) {
        return musteriRepository.findById(id).map(m -> {
            m.setMusteriAdi(request.getMusteriAdi());
            m.setMusteriSoyadi(request.getMusteriSoyadi());
            m.setMusteriTelefon(request.getMusteriTelefon());
            m.setMusteriEmail(request.getMusteriEposta());
            if (request.getMusteriSifre() != null && !request.getMusteriSifre().isBlank()) {
                m.setMusteriSifre(passwordEncoder.encode(request.getMusteriSifre()));
            }
            m.setMusteriOdemeYontemi(request.getMusteriOdemeYontemi());
            return mapToResponse(musteriRepository.save(m));
        });
    }


    private MusteriResponse mapToResponse(Musteri m) {
        return new MusteriResponse(
                m.getMusteriID(),
                m.getMusteriAdi(),
                m.getMusteriSoyadi(),
                m.getMusteriTelefon(),
                m.getMusteriEmail(),
                m.getMusteriOdemeYontemi()
        );
    }
}
