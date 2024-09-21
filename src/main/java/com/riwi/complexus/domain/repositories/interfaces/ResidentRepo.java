package com.riwi.complexus.domain.repositories.interfaces;

import com.riwi.complexus.domain.entities.ResidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepo extends JpaRepository<ResidentEntity, Long> {
}
