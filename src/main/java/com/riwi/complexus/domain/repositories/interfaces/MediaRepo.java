package com.riwi.complexus.domain.repositories.interfaces;

import com.riwi.complexus.domain.entities.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepo extends JpaRepository<MediaEntity,Long> {
}
