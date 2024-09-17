package com.riwi.complexus.infrastructure.services;

import com.riwi.complexus.domain.entities.RolsEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.repositories.interfaces.RolRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {

    @Autowired
    RolRepo rolRepo;

    @Override
    public ResponseEntity<RolsEntity> create(RolsEntity rolEntity) {
        RolsEntity role = RolsEntity.builder()
                .name(rolEntity.getName())
                .build();
        RolsEntity saveRol = rolRepo.save(role);
        return ResponseEntity.status(HttpStatus.OK).body(saveRol);
    }

    @Override
    public void delete(Long id) {
        rolRepo.deleteById(id);
    }

    @Override
    public List<RolsEntity> readAll() {
        return rolRepo.findAll();
    }

    @Override
    public RolsEntity readById(Long id) {
        return rolRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol not found"));
    }

    @Override
    public ResponseEntity<RolsEntity> update(Long id, RolsEntity rolEntity) {
        RolsEntity rolExisting = rolRepo.findById(id).orElse(null);
        if (rolExisting != null) {
            rolExisting.setName(rolEntity.getName());

            RolsEntity saveRol = rolRepo.save(rolExisting);
            return ResponseEntity.ok(saveRol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
