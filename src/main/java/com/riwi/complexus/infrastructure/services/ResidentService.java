package com.riwi.complexus.infrastructure.services;

import com.riwi.complexus.api.dto.request.ResidentDto;
import com.riwi.complexus.domain.entities.ResidentEntity;
import com.riwi.complexus.domain.entities.ResidentialUnitEntity;
import com.riwi.complexus.domain.entities.RolsEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.repositories.interfaces.ResidentRepo;
import com.riwi.complexus.domain.repositories.interfaces.ResidentialUnitRepo;
import com.riwi.complexus.domain.repositories.interfaces.UserRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IResidentService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentService implements IResidentService {

    @Autowired
    ResidentRepo residentRepo;

    @Autowired
    RolService rolService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    ResidentialUnitRepo residentialUnitRepo ;

    @Override
    public void delete(Long id) {
        residentRepo.deleteById(id);
    }

    @Override
    public List<ResidentEntity> readAll() {
        return residentRepo.findAll();
    }

    @Override
    public ResidentEntity readById(Long id) {
        return residentRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Resident Not Found"));
    }

    public ResidentDto create(@Valid ResidentDto entity) {
        // 1. Check if residential unit exists
        ResidentialUnitEntity residentialUnit = residentialUnitRepo.findById(entity.getResidentialUnitId())
                .orElseThrow(() -> new RuntimeException("ResidentialUnitId Not Found"));
        // 2. Create user

        RolsEntity rol = rolService.readById(entity.getRoleId());

        UserEntity newUser = UserEntity.builder()
                .name(entity.getName())
                .username(entity.getUsername())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .password(passwordEncoder.encode(entity.getPassword()))
                .phone(entity.getPhone())
                .role(rol)
                .build();

        UserEntity createNewUser = userRepo.save(newUser);

        // 3. Create resident with the created user

        ResidentEntity newResident = ResidentEntity.builder()
                .tower(entity.getTower())
                .residentialNumber(entity.getResidentialNumber())
                .allowedNotification(true)
                .userId(createNewUser)
                .residentialUnitId(residentialUnit)
                .build();

        ResidentEntity createdResident = residentRepo.save(newResident);


        ResidentDto response = new ResidentDto();
        return ResponseEntity.ok(response).getBody();
    }

    @Override
    public ResponseEntity<ResidentEntity> update(Long id, ResidentEntity residentEntity) {

        ResidentEntity residentExisting = residentRepo.findById(id).orElse(null);
        if(residentExisting != null){
            residentExisting.setTower(residentEntity.getTower());
            residentExisting.setResidentialNumber(residentEntity.getResidentialNumber());
            residentExisting.setAllowedNotification(residentEntity.getAllowedNotification());
            residentExisting.setUserId(residentEntity.getUserId());
            residentExisting.setResidentialUnitId(residentEntity.getResidentialUnitId());

            ResidentEntity saveResident = residentRepo.save(residentExisting);
            return ResponseEntity.ok(saveResident);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
