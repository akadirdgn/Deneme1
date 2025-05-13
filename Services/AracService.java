package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Arac;
import com.rent_a_car.backend.Repository.AracRepository;
import com.rent_a_car.backend.Dto.createRequest.CreateAracRequest;
import com.rent_a_car.backend.Dto.updateRequest.UpdateAracRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AracService {

    @Autowired
    private AracRepository aracRepository;

    public List<Arac> getAllAraclar() {
        return aracRepository.findAll();
    }

    public Optional<Arac> getAracById(int id) {
        return aracRepository.findById(id);
    }

    public Arac createArac(CreateAracRequest createAracRequest) {
        Arac arac = new Arac();
        arac.setAracAd(createAracRequest.getAracAd());
        arac.setAracModel(createAracRequest.getAracModel());
        arac.setAracPlaka(createAracRequest.getAracPlaka());
        arac.setAracKiralamaFiyati(createAracRequest.getAracKiralamaFiyati());
        arac.setAracDurum(createAracRequest.getAracDurum());
        arac.setAracAciklama(createAracRequest.getAracAciklama());
        arac.setSigortaliMi(createAracRequest.isSigortaliMi());
        arac.setSonBakimTarihi(createAracRequest.getSonBakimTarihi());

        return aracRepository.save(arac);
    }

    public Optional<Arac> updateArac(int id, UpdateAracRequest updateAracRequest) {
        return aracRepository.findById(id).map(arac -> {
            arac.setAracAd(updateAracRequest.getAracAd());
            arac.setAracModel(updateAracRequest.getAracModel());
            arac.setAracPlaka(updateAracRequest.getAracPlaka());
            arac.setAracKiralamaFiyati(updateAracRequest.getAracKiralamaFiyati());
            arac.setAracDurum(updateAracRequest.getAracDurum());
            arac.setAracAciklama(updateAracRequest.getAracAciklama());
            arac.setSigortaliMi(updateAracRequest.isSigortaliMi());
            arac.setSonBakimTarihi(updateAracRequest.getSonBakimTarihi());

            return aracRepository.save(arac);
        });
    }

    public boolean deleteArac(int id) {
        if (aracRepository.existsById(id)) {
            aracRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

