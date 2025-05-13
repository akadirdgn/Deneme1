package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Odeme;
import com.rent_a_car.backend.Repository.OdemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.rent_a_car.backend.Entity.Rezervasyon;
import com.rent_a_car.backend.Repository.RezervasyonRepository;
import com.rent_a_car.backend.Dto.createRequest.CreateOdemeRequest;
import com.rent_a_car.backend.Dto.response.OdemeResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateOdemeRequest;

import java.util.stream.Collectors;

@Service
public class OdemeService {

    @Autowired
    private OdemeRepository odemeRepository;

    @Autowired
    private RezervasyonRepository rezervasyonRepository;

    public List<OdemeResponse> getAllOdemeler() {
        return odemeRepository.findAll().stream().map(odeme ->
                new OdemeResponse(odeme.getOdemeID(),
                        odeme.getRezervasyon().getRezervasyonID(),
                        odeme.getDurum(),
                        odeme.getTutar(),
                        odeme.getOdemeTarihi())
        ).collect(Collectors.toList());
    }

    public Optional<OdemeResponse> getOdemeById(int id) {
        return odemeRepository.findById(id).map(odeme ->
                new OdemeResponse(odeme.getOdemeID(),
                        odeme.getRezervasyon().getRezervasyonID(),
                        odeme.getDurum(),
                        odeme.getTutar(),
                        odeme.getOdemeTarihi())
        );
    }

    public Optional<OdemeResponse> createOdeme(CreateOdemeRequest request) {
        Optional<Rezervasyon> rezervasyon = rezervasyonRepository.findById(request.getRezervasyonId());
        if (rezervasyon.isEmpty()) return Optional.empty();

        Odeme odeme = new Odeme();
        odeme.setRezervasyon(rezervasyon.get());
        odeme.setDurum(request.getDurum());
        odeme.setTutar(request.getTutar());
        odeme.setOdemeTarihi(request.getOdemeTarihi());

        Odeme saved = odemeRepository.save(odeme);
        return Optional.of(new OdemeResponse(saved.getOdemeID(),
                saved.getRezervasyon().getRezervasyonID(),
                saved.getDurum(),
                saved.getTutar(),
                saved.getOdemeTarihi()));
    }

    public Optional<OdemeResponse> updateOdeme(int id, UpdateOdemeRequest request) {
        return odemeRepository.findById(id).map(existing -> {
            existing.setDurum(request.getDurum());
            existing.setTutar(request.getTutar());
            existing.setOdemeTarihi(request.getOdemeTarihi());

            Odeme updated = odemeRepository.save(existing);
            return new OdemeResponse(updated.getOdemeID(),
                    updated.getRezervasyon().getRezervasyonID(),
                    updated.getDurum(),
                    updated.getTutar(),
                    updated.getOdemeTarihi());
        });
    }

    public boolean deleteOdeme(int id) {
        if (!odemeRepository.existsById(id)) return false;
        odemeRepository.deleteById(id);
        return true;
    }
}

