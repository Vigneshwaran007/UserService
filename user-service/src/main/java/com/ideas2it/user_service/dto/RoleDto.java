package com.ideas2it.user_service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="role_tb")
public class RoleDto implements Serializable{
	@Id
	@Column(name="role_id",columnDefinition = "VARCHAR(200)",insertable = false, updatable = false, nullable = false)
	@Type(type="uuid-char")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	private UUID roleId;
	@Column(name="role_name")
	private String roleName;
	@OneToMany(targetEntity = UserDto.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="role_id",referencedColumnName = "role_id")
	private List<UserDto> users;
	}
	
