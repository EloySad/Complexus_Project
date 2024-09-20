package com.riwi.complexus.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.complexus.domain.entities.ReactionsEntity;

@Repository
public interface ReactionsRepo extends JpaRepository<ReactionsEntity, Long>{
    
    @Query("SELECT COUNT(r) FROM ReactionsEntity r WHERE r.post.id = :postId")
    int countReactionsByPostId(Long postId);
}
