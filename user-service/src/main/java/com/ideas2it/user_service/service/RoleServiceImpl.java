package com.ideas2it.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.user_service.dto.RoleDto;
import com.ideas2it.user_service.entity.RoleEntity;
import com.ideas2it.user_service.repository.RoleRepository;


/**
 * RoleServiceImpl which implements RoleService.
 * @author Kowshik Bharathi M
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public RoleEntity save(RoleEntity roleEntity) {
		return RoleEntity.formEntity(roleRepository.save(RoleEntity.formDto(roleEntity)));
	}

	@Override
	public List<RoleDto> getRoles() {
		return roleRepository.findAll();
	}
	
	
}
 