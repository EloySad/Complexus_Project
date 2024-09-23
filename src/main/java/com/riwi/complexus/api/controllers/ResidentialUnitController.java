package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.ResidentialUnitRequest;
import com.riwi.complexus.domain.entities.ResidentialUnitEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentialUnitService;
import com.riwi.complexus.infrastructure.services.ResidentialUnitService;
import com.riwi.complexus.infrastructure.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residentialUnit")
@Tag(name = "ResidentialUnit", description = "ResidentialUnit Manager.")
public class ResidentialUnitController implements IResidentialUnitService {

    @Autowired
    ResidentialUnitService residentialUnitService;

    @Autowired
    UserService userService;

    @Override
    @PostMapping("/createUnit")
    @Operation(
            summary = "Create a residential unit.",
            description = "Creates a new residential unit in the system.")
    public ResponseEntity<ResidentialUnitEntity> createDTO(@RequestBody ResidentialUnitRequest residentialUnitRequestDTO) {
        return residentialUnitService.createDTO(residentialUnitRequestDTO);
    }

    @Override
    @DeleteMapping("/deleteUnit/{id}")
    @Operation(
            summary = "Delete a residential unit.",
            description = "Remove a residential unit from the system using its ID.")
    public void delete(@PathVariable Long id) {
        residentialUnitService.delete(id);
    }

    @Override
    @GetMapping("/readAllUnit")
    @Operation(
            summary = "Read all residential units.",
            description = "Retrieves a list of all residential units in the system.")
    public List<ResidentialUnitEntity> readAll() {
        return residentialUnitService.readAll();
    }

    @Override
    @GetMapping("/readByIdUnit/{id}")
    @Operation(
            summary = "Read a residential unit.",
            description = "Read the details of a specific residential unit using its ID.")
    public ResidentialUnitEntity readById(@PathVariable Long id) {
        return residentialUnitService.readById(id);
    }

    @Override
    @PutMapping("/updateUnit/{id}")
    @Operation(
            summary = "Update a residential unit.",
            description = "Update the details of an existing residential unit.")
    public ResponseEntity<ResidentialUnitEntity> update(@PathVariable Long id,@RequestBody ResidentialUnitRequest residentialUnitRequest) {
        return residentialUnitService.update(id, residentialUnitRequest);
    }
}
