package com.ideas2it.user_service.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ideas2it.user_service.dto.RoleDto;

/**
 * RoleRepository repository for Role table.
 * 
 * @author Vigneshwaran N
 */
@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<RoleDto, UUID> {

}
