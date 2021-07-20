package com.ideas2it.user_service.service;

import java.util.List;

import com.ideas2it.user_service.dto.UserDto;
import com.ideas2it.user_service.entity.SearchEntity;
import com.ideas2it.user_service.entity.UserEntity;

public interface UserService {

	/**
	 * save method is used save record in user table
	 * 
	 * @param userEntity.
	 * @return UserEntity
	 */
	public UserEntity save(UserEntity userEntity);
	
	
	public List<UserDto> getData();


	public SearchEntity getUserRoleByName(String name);


	public boolean updateUser(UserEntity userEntity);


	public boolean deleteUser(String userName);
}
