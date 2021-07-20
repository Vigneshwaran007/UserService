package com.ideas2it.user_service.service;

import java.util.List;

import com.ideas2it.user_service.dto.RoleDto;
import com.ideas2it.user_service.entity.RoleEntity;

public interface RoleService {
	 public RoleEntity save(RoleEntity roleEntity);
	 
	 public List<RoleDto> getRoles();

}
