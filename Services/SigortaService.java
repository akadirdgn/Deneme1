package com.rent_a_car.backend.Services;

import com.rent_a_car.backend.Entity.Arac;
import com.rent_a_car.backend.Entity.Sigorta;
import com.rent_a_car.backend.Repository.SigortaRepository;
import com.rent_a_car.backend.Dto.createRequest.CreateSigortaRequest;
import com.rent_a_car.backend.Dto.response.SigortaResponse;
import com.rent_a_car.backend.Dto.updateRequest.UpdateSigortaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SigortaService {

    @Autowired
    private SigortaRepository sigortaRepository;

    public List<SigortaResponse> getAllSigortalar() {
        return sigortaRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public SigortaResponse getSigortaById(int id) {
        Optional<Sigorta> sigorta = sigortaRepository.findById(id);
        return sigorta.map(this::convertToResponse).orElse(null);
    }

    public SigortaResponse createSigorta(CreateSigortaRequest request) {
        Sigorta sigorta = new Sigorta();
        Arac arac = new Arac();
        arac.setAracID(request.getAracID());
        sigorta.setArac(arac);
        sigorta.setSaglayici(request.getSaglayici());
        sigorta.setKapsamTutari(request.getKapsamTutari());
        sigorta.setBaslangicTarihi(request.getBaslangicTarihi());
        sigorta.setBitisTarihi(request.getBitisTarihi());
        sigorta.setSigortaDurum(request.getSigortaDurum());

        Sigorta saved = sigortaRepository.save(sigorta);
        return convertToResponse(saved);
    }

    public SigortaResponse updateSigorta(int id, UpdateSigortaRequest request) {
        Optional<Sigorta> sigortaOpt = sigortaRepository.findById(id);
        if (!sigortaOpt.isPresent()) return null;

        Sigorta sigorta = sigortaOpt.get();
        sigorta.setSaglayici(request.getSaglayici());
        sigorta.setKapsamTutari(request.getKapsamTutari());
        sigorta.setBaslangicTarihi(request.getBaslangicTarihi());
        sigorta.setBitisTarihi(request.getBitisTarihi());
        sigorta.setSigortaDurum(request.getSigortaDurum());

        Sigorta updated = sigortaRepository.save(sigorta);
        return convertToResponse(updated);
    }

    public boolean deleteSigorta(int id) {
        Optional<Sigorta> sigorta = sigortaRepository.findById(id);
        if (sigorta.isPresent()) {
            sigortaRepository.delete(sigorta.get());
            return true;
        }
        return false;
    }

    private SigortaResponse convertToResponse(Sigorta sigorta) {
        SigortaResponse response = new SigortaResponse();
        response.setSigortaID(sigorta.getSigortaID());
        response.setAracID(sigorta.getArac().getAracID());
        response.setSaglayici(sigorta.getSaglayici());
        response.setKapsamTutari(sigorta.getKapsamTutari());
        response.setBaslangicTarihi(sigorta.getBaslangicTarihi());
        response.setBitisTarihi(sigorta.getBitisTarihi());
        response.setSigortaDurum(sigorta.getSigortaDurum());
        return response;
    }
}
