package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.ResidentDto;
import com.riwi.complexus.api.dto.request.ResidentialUnitRequest;
import com.riwi.complexus.domain.entities.ResidentEntity;
import com.riwi.complexus.domain.entities.ResidentialUnitEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentService;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentialUnitService;
import com.riwi.complexus.infrastructure.services.ResidentService;
import com.riwi.complexus.infrastructure.services.ResidentialUnitService;
import com.riwi.complexus.infrastructure.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            summary = "Delete Residential Unit ",
            description = "Permanently delete a Residential Unit by id.")
    public void delete(@PathVariable Long id) {
        residentialUnitService.delete(id);
    }

    @Override
    @GetMapping("/readAllUnit")
    @Operation(
            summary = "Read all Residential Unit",
            description = "View the information of registered residential unit")

    public List<ResidentialUnitEntity> readAll() {
        return residentialUnitService.readAll();
    }

    @Override
    @GetMapping("/readByIdUnit/{id}")
    @Operation(
            summary = "Read Residential Unit by id",
            description = "View the information of registered residential unit according to their ids.")
    public ResidentialUnitEntity readById(@PathVariable Long id) {
        return residentialUnitService.readById(id);
    }

    @Override
    @PutMapping("/updateUnit/{id}")
    @Operation(
            summary = "Update Residential Unit",
            description = "Editing of Residential unit, in this endpoint you can modify residential unit data.")
    public ResponseEntity<ResidentialUnitEntity> update(@PathVariable Long id,@RequestBody ResidentialUnitRequest residentialUnitRequest) {
        return residentialUnitService.update(id, residentialUnitRequest);
    }
}
