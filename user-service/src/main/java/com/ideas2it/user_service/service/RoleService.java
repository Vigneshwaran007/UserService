package com.ideas2it.user_service.service;

import java.util.List;

import com.ideas2it.user_service.entity.RoleEntity;

/**
 * RoleService which is used for role table CRUD.
 * 
 * @author Vigneshwaran N
 */
public interface RoleService {

	/**
	 * save method is used for save new role in table.
	 * 
	 * @param roleEntity
	 */
	public RoleEntity save(RoleEntity roleEntity);

	/**
	 * getRoles method is used get all role from table.
	 *
	 */
	public List<RoleEntity> getRoles();

}
