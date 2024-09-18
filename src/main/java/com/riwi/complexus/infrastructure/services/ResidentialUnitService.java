package com.riwi.complexus.infrastructure.services;

import com.riwi.complexus.api.dto.request.ResidentialUnitRequest;
import com.riwi.complexus.domain.entities.ResidentialUnitEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.repositories.interfaces.ResidentialUnitRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentialUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentialUnitService implements IResidentialUnitService {

    @Autowired
    ResidentialUnitRepo residentialUnitRepo;

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<ResidentialUnitEntity> createDTO(ResidentialUnitRequest residentialUnitDTO) {
        UserEntity user = userService.readById(residentialUnitDTO.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Crear la entidad ResidentialUnitEntity
        ResidentialUnitEntity residentialUnit = ResidentialUnitEntity.builder()
                .name(residentialUnitDTO.getName())
                .city(residentialUnitDTO.getCity())
                .address(residentialUnitDTO.getAdress())
                .user(user)
                .build();

        ResidentialUnitEntity savedUnit = residentialUnitRepo.save(residentialUnit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUnit);
    }

    @Override
    public void delete(Long id) {
        residentialUnitRepo.deleteById(id);
    }

    @Override
    public List<ResidentialUnitEntity> readAll() {
        return residentialUnitRepo.findAll();
    }

    @Override
    public ResidentialUnitEntity readById(Long id) {
        return residentialUnitRepo.findById(id).orElseThrow(()-> new RuntimeException("Residential Unit Not Found"));
    }

    @Override
    public ResponseEntity<ResidentialUnitEntity> update(Long id, ResidentialUnitRequest residentialUnitRequest) {
        ResidentialUnitEntity residentialUnitExisting = residentialUnitRepo.findById(id).orElse(null);
        UserEntity user = userService.readById(residentialUnitRequest.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if(residentialUnitExisting != null){
            residentialUnitExisting.setName(residentialUnitRequest.getName());
            residentialUnitExisting.setCity(residentialUnitRequest.getCity());
            residentialUnitExisting.setAddress(residentialUnitRequest.getAdress());
            residentialUnitExisting.setUser(user);

            ResidentialUnitEntity residentialUnit = residentialUnitRepo.save(residentialUnitExisting);
            return ResponseEntity.ok(residentialUnit);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
