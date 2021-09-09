package com.ideas2it.user_service.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ideas2it.user_service.entity.ResultEntity;
import com.ideas2it.user_service.entity.SearchEntity;
import com.ideas2it.user_service.entity.UserEntity;

/**
 * UserService which is used for User table CRUD and user authentication.
 * 
 * @author Vigneshwaran N
 */
public interface UserService extends UserDetailsService {

	/**
	 * save method is used save record in user table
	 * 
	 * @param userEntity.
	 * @return UserEntity
	 */
	public UserEntity save(UserEntity userEntity);

	/**
	 * getData method is used get record from user table
	 * 
	 * @return List<UserEntity>
	 */
	public List<UserEntity> getData();

	/**
	 * getUserRoleByName method is used get role of a user
	 * 
	 * @param name
	 * @return SearchEntity
	 */
	public SearchEntity getUserRoleByName(String name);

	/**
	 * updateUser method is used update details of a user
	 * 
	 * @param userEntity
	 * @return ResultEntity
	 */
	public ResultEntity updateUser(UserEntity userEntity);

	/**
	 * deleteUser method is used delete user
	 * 
	 * @param userName
	 * @return ResultEntity
	 */
	public ResultEntity deleteUser(String userName);
}
