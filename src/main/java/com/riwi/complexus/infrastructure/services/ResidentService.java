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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentService implements IResidentService{

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

        ResidentialUnitEntity residentialUnit = residentialUnitRepo.findById(entity.getResidentialUnitId())
                .orElseThrow(() -> new RuntimeException("ResidentialUnitId Not Found"));


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



        ResidentEntity newResident = ResidentEntity.builder()
                .tower(entity.getTower())
                .residentialNumber(entity.getResidentialNumber())
                .allowedNotification(true)
                .userId(createNewUser)
                .residentialUnitId(residentialUnit)
                .build();

        ResidentEntity createdResident = residentRepo.save(newResident);


        ResidentDto response = new ResidentDto();
        response.setName(createdResident.getUserId().getName());
        response.setUsername(createdResident.getUserId().getUsername());
        response.setLastname(createdResident.getUserId().getLastname());
        response.setEmail(createdResident.getUserId().getEmail());
        response.setPhone(createdResident.getUserId().getPhone());
        response.setTower(createdResident.getTower());
        response.setResidentialNumber(createdResident.getResidentialNumber());
        response.setResidentialUnitId(createdResident.getResidentialUnitId().getId());
        response.setRoleId(createdResident.getUserId().getRole().getId());

        return response;
    }


    public ResidentDto update(Long id, @Valid ResidentDto entity) {

        ResidentEntity existingResident = residentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident Not Found"));


        ResidentialUnitEntity residentialUnit = residentialUnitRepo.findById(entity.getResidentialUnitId())
                .orElseThrow(() -> new RuntimeException("ResidentialUnitId Not Found"));


        UserEntity existingUser = existingResident.getUserId();
        existingUser.setName(entity.getName());
        existingUser.setUsername(entity.getUsername());
        existingUser.setLastname(entity.getLastname());
        existingUser.setEmail(entity.getEmail());
        existingUser.setPhone(entity.getPhone());


        if (entity.getPassword() != null && !entity.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(entity.getPassword()));
        }

        userRepo.save(existingUser);


        existingResident.setTower(entity.getTower());
        existingResident.setResidentialNumber(entity.getResidentialNumber());
        existingResident.setResidentialUnitId(residentialUnit);

        ResidentEntity updatedResident = residentRepo.save(existingResident);


        ResidentDto response = new ResidentDto();
        response.setName(updatedResident.getUserId().getName());
        response.setUsername(updatedResident.getUserId().getUsername());
        response.setLastname(updatedResident.getUserId().getLastname());
        response.setEmail(updatedResident.getUserId().getEmail());
        response.setPhone(updatedResident.getUserId().getPhone());
        response.setTower(updatedResident.getTower());
        response.setResidentialNumber(updatedResident.getResidentialNumber());
        response.setResidentialUnitId(updatedResident.getResidentialUnitId().getId());
        response.setRoleId(updatedResident.getUserId().getRole().getId());

        return response;
    }
}

