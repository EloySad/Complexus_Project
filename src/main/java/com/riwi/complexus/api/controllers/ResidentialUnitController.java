package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.ResidentialUnitRequest;
import com.riwi.complexus.domain.entities.ResidentialUnitEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentialUnitService;
import com.riwi.complexus.infrastructure.services.ResidentialUnitService;
import com.riwi.complexus.infrastructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residentialUnit")
public class ResidentialUnitController implements IResidentialUnitService {

    @Autowired
    ResidentialUnitService residentialUnitService;

    @Autowired
    UserService userService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<ResidentialUnitEntity> createDTO(@RequestBody ResidentialUnitRequest residentialUnitRequestDTO) {
        return residentialUnitService.createDTO(residentialUnitRequestDTO);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        residentialUnitService.delete(id);
    }

    @Override
    @GetMapping("/readAll")
    public List<ResidentialUnitEntity> readAll() {
        return residentialUnitService.readAll();
    }

    @Override
    @GetMapping("/readById/{id}")
    public ResidentialUnitEntity readById(@PathVariable Long id) {
        return residentialUnitService.readById(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<ResidentialUnitEntity> update(@PathVariable Long id,@RequestBody ResidentialUnitEntity residentialUnitEntity) {
        return residentialUnitService.update(id, residentialUnitEntity);
    }
}
