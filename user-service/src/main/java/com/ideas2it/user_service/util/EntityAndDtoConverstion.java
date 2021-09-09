package com.ideas2it.user_service.util;

import com.ideas2it.user_service.dto.RoleDto;
import com.ideas2it.user_service.dto.UserDto;
import com.ideas2it.user_service.entity.RoleEntity;
import com.ideas2it.user_service.entity.UserEntity;

/**
 * EntityAndDtoConverstion which converts dto to entity and entity to dto.
 * 
 * @author Vigneshwaran N
 */
public class EntityAndDtoConverstion {

	/**
	 * formEntity which converts RoleDto to RoleEntity.
	 * 
	 * @param roleDto
	 * @author Vigneshwaran N
	 */
	public static RoleEntity formEntity(RoleDto roleDto) {
		RoleEntity roleEntity = new RoleEntity.RoleBuilder().roleId(roleDto.getRoleId()).roleName(roleDto.getRoleName())
				.build();
		return roleEntity;
	}

	/**
	 * formDto which converts RoleEntity to RoleDto.
	 * 
	 * @param roleEntity
	 * @author Vigneshwaran N
	 */
	public static RoleDto formDto(RoleEntity roleEntity) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleId(roleEntity.getRoleId());
		roleDto.setRoleName(roleEntity.getRoleName());
		return roleDto;
	}

	/**
	 * formEntity which converts UserDto to UserEntity.
	 * 
	 * @param userDto
	 * @author Vigneshwaran N
	 */
	public static UserEntity formEntity(UserDto userDto) {
		UserEntity entity = new UserEntity.UserBuilder().userId(userDto.getUserId()).userName(userDto.getUserName())
				.password(userDto.getPassword()).roleId(userDto.getRoleId()).createdTime(userDto.getCreatedTime())
				.lastUpdatedTime(userDto.getLastUpdatedTime()).build();
		return entity;
	}

	/**
	 * formDto which converts UserEntity to UserDto.
	 * 
	 * @param userEntity
	 * @author Vigneshwaran N
	 */
	public static UserDto formDto(UserEntity userEntity) {
		UserDto dto = new UserDto();
		dto.setUserId(userEntity.getUserId());
		dto.setUserName(userEntity.getUserName());
		dto.setPassword(userEntity.getPassword());
		dto.setRoleId(userEntity.getRoleId());
		dto.setCreatedTime(userEntity.getCreatedTime());
		dto.setLastUpdatedTime(userEntity.getLastUpdatedTime());
		return dto;

	}

}
