package com.ideas2it.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.user_service.api.advice.TimeTrackerAnnotation;
import com.ideas2it.user_service.entity.AuthenticationEntity;
import com.ideas2it.user_service.entity.ResultEntity;
import com.ideas2it.user_service.entity.RoleEntity;
import com.ideas2it.user_service.entity.SearchEntity;
import com.ideas2it.user_service.entity.UserEntity;
import com.ideas2it.user_service.manager.TokenManager;
import com.ideas2it.user_service.service.RoleService;
import com.ideas2it.user_service.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * UserController which is used for User end point.
 * 
 * @author Vigneshwaran N
 */
@RestController
@RequestMapping("/users")
public class UserInfoController {
	public static int saveCount = 0;
	public static int updateCount = 0;
	public static int deleteCount = 0;

	@Autowired
	public UserInfoController(UserService service, RoleService roleService, TokenManager tokenManager) {
		this.service = service;
		this.roleService = roleService;
		this.tokenManager = tokenManager;
	}

	private final UserService service;
	private final RoleService roleService;
	private final TokenManager tokenManager;

	/**
	 * registerUser method is used to register User.
	 * 
	 * @param userEntity
	 * @author Vigneshwaran N
	 */
	@PostMapping("/")
	@ApiOperation(value = "Register User Detail API")
	@TimeTrackerAnnotation
	public UserEntity registerUser(@RequestBody UserEntity userEntity) {
		return service.save(userEntity);
	}

	/**
	 * getUser method is used to get all Users.
	 * 
	 * @author Vigneshwaran N
	 */
	@GetMapping("/")
	@ApiOperation(value = "Get User Detail API")
	@TimeTrackerAnnotation
	public List<UserEntity> getUser() {
		return service.getData();
	}

	/**
	 * registerRole method is used to register a new role.
	 * 
	 * @author Vigneshwaran N
	 */
	@PostMapping("/roles")
	@ApiOperation(value = "Register User Detail API")
	@TimeTrackerAnnotation
	public RoleEntity registerRole(@RequestBody RoleEntity roleEntity) {
		return roleService.save(roleEntity);
	}

	/**
	 * getRoles method is used to get all registered roles.
	 * 
	 * @author Vigneshwaran N
	 */
	@GetMapping("/roles")
	@ApiOperation(value = "Get Roles API")
	@TimeTrackerAnnotation
	public List<RoleEntity> getRoles() {
		return roleService.getRoles();
	}

	/**
	 * getUserRoleByName method is used to get user role.
	 * 
	 * @param name
	 * @author Vigneshwaran N
	 */
	@GetMapping("/{name}")
	@ApiOperation(value = "Get User Role By Name API")
	@TimeTrackerAnnotation
	public SearchEntity getUserRoleByName(
			@ApiParam(value = "Enter UserName for retrive detail", required = true) @PathVariable String name) {
		return service.getUserRoleByName(name);
	}

	/**
	 * updateUser method is used to update user detail.
	 * 
	 * @param userEntity
	 * @author Vigneshwaran N
	 */
	@PutMapping("/")
	@ApiOperation(value = "Update User by UserEntity API")
	@TimeTrackerAnnotation
	public ResultEntity updateUser(@RequestBody UserEntity userEntity) {
		ResultEntity result = service.updateUser(userEntity);
		return result;
	}

	/**
	 * deleteUser method is used to delete user detail.
	 * 
	 * @param name
	 * @author Vigneshwaran N
	 */
	@DeleteMapping("/{name}")
	@ApiOperation(value = "Delete User by userName API")
	@TimeTrackerAnnotation
	public ResultEntity deleteUser(@PathVariable String name) {
		ResultEntity result = service.deleteUser(name);
		return result;
	}

	/**
	 * generateToken method is used for token authentication.
	 * 
	 * @param authenticateEntity
	 * @return String
	 * @throws Exception
	 */
	@ApiOperation(value = "Authenticate API")
	@PostMapping("/authenticate")
	public AuthenticationEntity generateToken(@RequestBody AuthenticationEntity authenticationEntity) throws Exception {
		return tokenManager.generateToken(authenticationEntity);
	}

}
