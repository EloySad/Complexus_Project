package com.riwi.complexus.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riwi.complexus.domain.entities.ReactionsEntity;
import com.riwi.complexus.domain.repositories.ReactionsRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IReactionsService;
import com.riwi.complexus.utils.exceptions.ResourceNotFoundException;

@Service
public class ReactionsService implements IReactionsService{

    @Autowired
    private ReactionsRepo reactionRepository;

    // Obtiene la cantidad de reacciones de un post.
    public int getReactionCount(Long postId) {
        return reactionRepository.countReactionsByPostId(postId);
    }

    // Crea una nueva reacción.
    @Override
    public ResponseEntity<ReactionsEntity> create(ReactionsEntity entity) {
        ReactionsEntity savedEntity = reactionRepository.save(entity);
        return ResponseEntity.ok(savedEntity); // Devuelve la entidad envuelta en un ResponseEntity
    }

    // Elimina una reacción por su ID.
    @Override
    public void delete(Long id) {
        ReactionsEntity existingEntity = reactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reacción no encontrada con id " + id));
        reactionRepository.delete(existingEntity);
    }

    // Obtiene todas las reacciones.
    @Override
    public List<ReactionsEntity> readAll() {
        return reactionRepository.findAll();
    }

    // Busca una reacción por su ID.
    @Override
    public ReactionsEntity readById(Long id) {
        return reactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reacción no encontrada con id " + id));
    }

    // Actualiza una reacción existente.
    @Override
    public ResponseEntity<ReactionsEntity> update(Long id, ReactionsEntity entity) {
        ReactionsEntity existingEntity = reactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reacción no encontrada con id " + id));

        existingEntity.setLiked(entity.getLiked());
        existingEntity.setCreatedAt(entity.getCreatedAt());
        existingEntity.setPost(entity.getPost());
        existingEntity.setUser(entity.getUser());

        ReactionsEntity updatedEntity = reactionRepository.save(existingEntity);
        return ResponseEntity.ok(updatedEntity); // Devuelve la entidad actualizada envuelta en un ResponseEntity
    }
    
}
