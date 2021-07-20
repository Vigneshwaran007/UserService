package com.ideas2it.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.user_service.dto.RoleDto;
import com.ideas2it.user_service.dto.UserDto;
import com.ideas2it.user_service.entity.RoleEntity;
import com.ideas2it.user_service.entity.SearchEntity;
import com.ideas2it.user_service.entity.UserEntity;
import com.ideas2it.user_service.service.RoleService;
import com.ideas2it.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserInfoController {
	
	@Autowired
	UserService service;
	@Autowired
	RoleService roleService;
	
	@PostMapping("/save")
	public UserEntity registerUser(@RequestBody UserEntity userEntity) {
		System.out.println("HIIIIIIIIIIIII");
		return service.save(userEntity);
	}
	
	@GetMapping("/")
	public List<UserDto> getDto(){
		return service.getData();
	}
	
	@GetMapping("/roles")
	public List<RoleDto> getRoles(){
		return roleService.getRoles();
	}
	
	@GetMapping("/{name}")
	public SearchEntity getUserRoleByName(@PathVariable String name) {
		return service.getUserRoleByName(name);
	}
	@PostMapping("/registerRole")
	public RoleEntity registerRole(@RequestBody RoleEntity roleEntity) {
		return roleService.save(roleEntity);
	}
	
	@PostMapping("/update")
	public boolean updateUser(@RequestBody UserEntity userEntity) {
		boolean result=service.updateUser(userEntity);
		return result;
	}
	
	@DeleteMapping("/delete/{name}")
	public boolean deleteUser(@PathVariable String name) {
		boolean result=service.deleteUser(name);
		return result;
	}
	

}
