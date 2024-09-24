package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.ResidentDto;
import com.riwi.complexus.domain.entities.ResidentEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentService;
import com.riwi.complexus.infrastructure.services.ResidentService;

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
@RequestMapping("/resident")
@Tag(name = "Resident", description = "Resident Manager.")
public class ResidentController{

    @Autowired
    private ResidentService residentService;

    @GetMapping("/readById/{id}")
    @Operation(
            summary = "Read a resident.",
            description = "Read the details of a specific resident using their ID.")
    public ResidentEntity readById(@PathVariable Long id) {

        return residentService.readById(id);
    }

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/create")
    @Operation(
            summary = "Create a resident.",
            description = "Creates a new resident in the system.")
    public ResponseEntity<ResidentDto> create(@Valid @RequestBody ResidentDto user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(residentService.create(user));
    }

    @DeleteMapping("/delete")
    @Operation(
            summary = "Delete a resident.",
            description = "Removes a resident from the system using their ID.")
    public void delete(Long id) {
        residentService.delete(id);
    }

    @GetMapping("/readAll")
    @Operation(
            summary = "Read all residents.",
            description = "Retrieves a list of all residents in the system.")
    public List<ResidentEntity> readAll() {

        return residentService.readAll();
    }

    @PutMapping("update/{id}")
    @Operation(
            summary = "Update a resident.",
            description = "Update the details of an existing resident.")
    public ResponseEntity<ResidentEntity> update(@PathVariable Long id,@RequestBody ResidentEntity resident) {
        return residentService.update(id, resident);
    }
}
