package com.ideas2it.user_service.repository;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ideas2it.user_service.dto.UserDto;
import com.ideas2it.user_service.entity.SearchEntity;

/**
 * UserRepository repository for User table.
 * 
 * @author Vigneshwaran N
 */
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserDto, UUID> {

	/**
	 * getUserRoleByName method is used to get role for a particular user
	 * 
	 * @param userName
	 * @return SearchEntity
	 */
	@Query("select new com.ideas2it.user_service.entity.SearchEntity(u.userName,r.roleName) from RoleDto r JOIN r.users u where u.userName= :name")
	public SearchEntity getUserRoleByName(String name);

	/**
	 * findByName method is used to get user detail by name
	 * 
	 * @param userName
	 * @return UserEntity
	 */
	@Query("select new com.ideas2it.user_service.dto.UserDto(u.userId,u.userName,u.password,u.roleId,u.createdTime,u.lastUpdatedTime) from UserDto u where u.userName= :userName")
	public UserDto findByName(String userName);

	/**
	 * updateByName method is used to update user detail by name
	 * 
	 * @param userName
	 * @return UserEntity
	 */
	@Modifying
	@Transactional
	@Query(value = "update UserDto set roleId = :roleId where userName= :name")
	public UserDto updateByName(UUID roleId, String name);

}