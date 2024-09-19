package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.ResidentDto;
import com.riwi.complexus.domain.entities.ResidentEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentService;
import com.riwi.complexus.infrastructure.services.ResidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resident")
public class ResidentController{

    @Autowired
    private ResidentService residentService;

    @GetMapping("/readById/{id}")
    public ResidentEntity readById(@PathVariable Long id) {

        return residentService.readById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResidentDto> create(@Valid @RequestBody ResidentDto user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(residentService.create(user));
    }

    @DeleteMapping("/delete")
    public void delete(Long id) {
        residentService.delete(id);
    }

    @GetMapping("/readAll")
    public List<ResidentEntity> readAll() {

        return residentService.readAll();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResidentEntity> update(@PathVariable Long id,@RequestBody ResidentEntity resident) {
        return residentService.update(id, resident);
    }
}
