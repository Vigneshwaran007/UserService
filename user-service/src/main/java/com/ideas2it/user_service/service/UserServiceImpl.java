package com.ideas2it.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.user_service.dto.UserDto;
import com.ideas2it.user_service.entity.SearchEntity;
import com.ideas2it.user_service.entity.UserEntity;
import com.ideas2it.user_service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
	    super();	
		this.userRepository=userRepository;
	}
	
	private final UserRepository userRepository;
	
	@Override
	public UserEntity save(UserEntity userEntity) {
		//userEntity.setLastUpdatedTime(new java.util.Date());
		// TODO Auto-generated method stub
		return UserEntity.formEntity(userRepository.save(UserEntity.formDto(userEntity)));
		
	}

	@Override
	public List<UserDto> getData() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public SearchEntity getUserRoleByName(String name) {
		return userRepository.getUserRoleByName(name);
	}

	@Override
	public boolean updateUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		UserEntity userEntity1=userRepository.findByName(userEntity.getUserName());
		if(userEntity1!=null) {
			//userRepository.
			System.out.println(userEntity.getRoleId());
			userRepository.updateByName(userEntity.getRoleId(),userEntity.getUserName());
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(String userName) {
		UserEntity userEntity=userRepository.findByName(userName);
		
		if(userEntity!=null) {
			userRepository.delete(UserEntity.formDto(userEntity));
			return true;
		}
		return false;
	}
	

}
