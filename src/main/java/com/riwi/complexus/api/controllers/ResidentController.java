package com.riwi.complexus.api.controllers;

import com.riwi.complexus.domain.entities.ResidentEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentService;
import com.riwi.complexus.infrastructure.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resident")
public class ResidentController implements IResidentService {

    @Autowired
    private ResidentService residentService;

    @GetMapping("/readById/{id}")
    public ResidentEntity readById(@PathVariable Long id) {

        return residentService.readById(id);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<ResidentEntity> create(ResidentEntity user) {

        return residentService.create(user);
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(Long id) {
        residentService.delete(id);
    }

    @Override
    @GetMapping("/readAll")
    public List<ResidentEntity> readAll() {

        return residentService.readAll();
    }

    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<ResidentEntity> update(@PathVariable Long id,@RequestBody ResidentEntity resident) {
        return residentService.update(id, resident);
    }
}
