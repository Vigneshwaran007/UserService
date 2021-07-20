package com.ideas2it.user_service.entity;

import java.util.Date;
import java.util.UUID;

import com.ideas2it.user_service.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	private UUID userId;
	private String userName;
	private UUID roleId;
	private Date createdTime;
	private Date lastUpdatedTime;
	
	public static UserEntity formEntity(UserDto userDto) {
		UserEntity entity=new UserEntity();
		entity.setUserId(userDto.getUserId());
		entity.setUserName(userDto.getUserName());
		entity.setRoleId(userDto.getRoleId());
		entity.setCreatedTime(userDto.getCreatedTime());
		entity.setLastUpdatedTime(userDto.getLastUpdatedTime());
		return entity;
		
	}
	
	public static UserDto formDto(UserEntity userEntity) {
		UserDto dto=new UserDto();
		dto.setUserId(userEntity.getUserId());
		dto.setUserName(userEntity.getUserName());
		dto.setRoleId(userEntity.getRoleId());
		dto.setCreatedTime(userEntity.getCreatedTime());
		dto.setLastUpdatedTime(userEntity.getLastUpdatedTime());
		return dto;
		
	}
}
