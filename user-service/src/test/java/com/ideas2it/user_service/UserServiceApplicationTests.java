package com.ideas2it.user_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.sql.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ideas2it.user_service.dto.UserDto;
import com.ideas2it.user_service.entity.SearchEntity;
import com.ideas2it.user_service.entity.UserEntity;
import com.ideas2it.user_service.repository.UserRepository;
import com.ideas2it.user_service.service.UserService;
import com.ideas2it.user_service.util.EntityAndDtoConverstion;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void saveServiceTest() {
		UserEntity entity=new UserEntity(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), "Revathi", "password",
				UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), Date.valueOf("2015-03-31"), Date.valueOf("2015-03-31"));
		when(userRepository.save(any(UserDto.class)))
		.thenReturn(EntityAndDtoConverstion.formDto(entity));
		assertNotNull(userService.save(entity));
	}
	
	@Test
	public void getDataServiceTest() {
		String sDate1 = "2015-03-31";
		Date date1 = Date.valueOf(sDate1);
		when(userRepository.findAll()).thenReturn(Stream
				.of(new UserDto(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), "vicky", "password",
						UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), date1, date1),new UserDto(UUID.fromString("fcb59852-5655-4d75-ab68-1545615"), "keerthi", "password",
								UUID.fromString("fcb59852-5655-4d75-ab68-456456456"), date1, date1))
				.collect(Collectors.toList()));
		assertEquals(2,userService.getData().size());
	}
	
	@Test
	public void getUserRoleByNameServiceTest() {
		
		
		when(userRepository.getUserRoleByName(anyString())).thenReturn(new SearchEntity.SearchBuilder().userName("viki").roleName("doctor").build());
		assertNotNull(userService.getUserRoleByName("viki"));
	}
	
	
	@Test
	public void updateUserServiceTest() {
		when(userRepository.findByName(anyString())).thenReturn(new UserDto(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), "vicky", "password",
				UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), Date.valueOf("2015-03-31"), Date.valueOf("2015-03-31")));
		
		when(userRepository.updateByName(any(UUID.class), anyString())).thenReturn(new UserDto(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), "vicky", "password",
				UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), Date.valueOf("2015-03-31"), Date.valueOf("2015-03-31")));
		
		assertTrue(userService.updateUser(EntityAndDtoConverstion.formEntity(new UserDto(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), "vicky", "password",
				UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), Date.valueOf("2015-03-31"), Date.valueOf("2015-03-31")))).isResult());
	}
	
	@Test
	public void deleteUser() {
		UserDto dto=new UserDto(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), "Revathi", "password",
				UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520"), Date.valueOf("2015-03-31"), Date.valueOf("2015-03-31"));
		when(userRepository.findByName(anyString())).thenReturn(dto);
		userService.deleteUser("Revathi");
		verify(userRepository, times(1)).delete(dto);
	}

}
