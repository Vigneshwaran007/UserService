package com.ideas2it.user_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ideas2it.user_service.controller.UserInfoController;
import com.ideas2it.user_service.dto.UserDto;
import com.ideas2it.user_service.entity.ResultEntity;
import com.ideas2it.user_service.entity.SearchEntity;
import com.ideas2it.user_service.entity.UserEntity;
import com.ideas2it.user_service.repository.UserRepository;
import com.ideas2it.user_service.util.EntityAndDtoConverstion;

/**
 * UserServiceImpl which implements UserService.
 * 
 * @author Vigneshwaran N
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserServiceImpl(UserRepository userRepository,DataSource dataSource) {
		super();
		this.userRepository = userRepository;
		this.dataSource=dataSource;
	}

	private final UserRepository userRepository;
	private final DataSource dataSource;
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public UserEntity save(UserEntity userEntity) {
		UserInfoController.saveCount++;
		return EntityAndDtoConverstion.formEntity(userRepository.save(EntityAndDtoConverstion.formDto(userEntity)));

	}

	@Override
	public List<UserEntity> getData() {
		List<UserDto> userDto = userRepository.findAll();
		logger.log(Level.ALL, "userDto " + userDto);
		List<UserEntity> liUserEntity = new ArrayList<>();
		logger.log(Level.ALL, "DataSource============= " + dataSource);

		liUserEntity = userDto.stream().map(dto -> EntityAndDtoConverstion.formEntity(dto))
				.collect(Collectors.toList());
		return liUserEntity;
	}

	@Override
	public SearchEntity getUserRoleByName(String name) {
		return userRepository.getUserRoleByName(name);
	}

	@Override
	public ResultEntity updateUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		UserDto userEntityDb = userRepository.findByName(userEntity.getUserName());
		if (userEntityDb != null) {
			logger.log(Level.ALL, "userDto " + userEntity.getRoleId());
			userRepository.updateByName(userEntity.getRoleId(), userEntity.getUserName());
			UserInfoController.updateCount++;
			return new ResultEntity.ResultEntityBuilder().result(true).build();
		}
		return new ResultEntity.ResultEntityBuilder().result(false).build();
	}

	@Override
	public ResultEntity deleteUser(String userName) {
		UserDto userDto = userRepository.findByName(userName);
		if (userDto != null) {
			userRepository.delete(userDto);
			UserInfoController.deleteCount++;
			return new ResultEntity.ResultEntityBuilder().result(true).build();
		}
		return new ResultEntity.ResultEntityBuilder().result(true).build();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userRepository.findByName(username);
		UserEntity userEntity = EntityAndDtoConverstion.formEntity(userDto);
		return new org.springframework.security.core.userdetails.User(userEntity.getUserName(),
				userEntity.getPassword(), new ArrayList<>());
	}
}
