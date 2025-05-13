package com.rent_a_car.backend.Controller;

import com.rent_a_car.backend.Services.AracGorselleriService;
import com.rent_a_car.backend.Dto.createRequest.CreateAracGorselleriRequest;
import com.rent_a_car.backend.Dto.updateRequest.UpdateAracGorselleriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/arac-gorselleri")
public class AracGorselleriController {

    @Autowired
    private AracGorselleriService aracGorselleriService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAracGorselleri() {
        return aracGorselleriService.getAllAracGorselleri();
    }

    @GetMapping("/arac/{id}")
    public ResponseEntity<?> getAracGorselleriByAracID(@PathVariable int id) {
        return aracGorselleriService.getAracGorselleriByAracID(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAracGorselById(@PathVariable int id) {
        return aracGorselleriService.getAracGorselById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAracGorsel(@RequestBody CreateAracGorselleriRequest request) {
        return aracGorselleriService.createAracGorsel(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAracGorsel(@PathVariable int id, @RequestBody UpdateAracGorselleriRequest request) {
        return aracGorselleriService.updateAracGorsel(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAracGorsel(@PathVariable int id) {
        return aracGorselleriService.deleteAracGorsel(id);
    }
}
