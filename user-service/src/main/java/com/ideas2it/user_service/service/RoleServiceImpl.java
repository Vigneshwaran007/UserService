package com.ideas2it.user_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.user_service.dto.RoleDto;
import com.ideas2it.user_service.entity.RoleEntity;
import com.ideas2it.user_service.repository.RoleRepository;
import com.ideas2it.user_service.util.EntityAndDtoConverstion;

/**
 * RoleServiceImpl which implements RoleService.
 * 
 * @author Vigneshwaran N
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleEntity save(RoleEntity roleEntity) {
		return EntityAndDtoConverstion.formEntity(roleRepository.save(EntityAndDtoConverstion.formDto(roleEntity)));
	}

	@Override
	public List<RoleEntity> getRoles() {
		List<RoleDto> roleDtoli=roleRepository.findAll();
		List<RoleEntity> roleEntityli=roleDtoli.stream().map(dto-> EntityAndDtoConverstion.formEntity(dto)).collect(Collectors.toList());
		return roleEntityli;
	}

}
