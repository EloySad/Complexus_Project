package com.riwi.complexus.domain.repositories.interfaces;

import com.riwi.complexus.domain.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<PostEntity, Long> {
}
