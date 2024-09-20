package com.riwi.complexus.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.complexus.domain.entities.ReactionsEntity;

@Repository
public interface ReactionsRepo extends JpaRepository<ReactionsEntity, Long> {
    int countReactionsByPostId(Long postId);
}