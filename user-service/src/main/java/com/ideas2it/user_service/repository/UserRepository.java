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
import com.ideas2it.user_service.entity.UserEntity;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserDto, UUID>{

	@Query("select new com.ideas2it.user_service.entity.SearchEntity(r.roleName,u.userName) from RoleDto r JOIN r.users u where u.userName= :name")
	public SearchEntity getUserRoleByName(String name);
	
	@Query("select new com.ideas2it.user_service.entity.UserEntity(u.userId,u.userName,u.roleId,u.createdTime,u.lastUpdatedTime) from UserDto u where u.userName= :userName")
	public UserEntity findByName(String userName);

	@Modifying
	@Transactional
	@Query(value="update UserDto set roleId = :roleId where userName= :name")
	public void updateByName(UUID roleId,String name);

	/*.
	 * 
	 * UserDto findByUserName(String userName);
	 * 
	 * @Query("SELECT new com.module.userInfoModule.userInfoModule.entity.UserQueryEntity(r.roleName,u.userId,u.userName) FROM RoleDto r JOIN r.users u WHERE u.userName= :userName"
	 * ) public UserQueryEntity getUserIdByName(String userName);
	 */
}