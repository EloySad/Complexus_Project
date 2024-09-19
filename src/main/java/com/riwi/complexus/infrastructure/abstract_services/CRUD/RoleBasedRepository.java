package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleBasedRepository <T, ID> extends JpaRepository<T, ID> {
    
    List<T> findByRole(String role);
}
