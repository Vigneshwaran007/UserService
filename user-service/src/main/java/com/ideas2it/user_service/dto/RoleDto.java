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

/**
 * RoleDto represent role table.
 * 
 * @author Vigneshwaran N
 *
 */
@Entity
@Table(name = "role_tb")
public class RoleDto implements Serializable {
	@Id
	@Column(name = "role_id", columnDefinition = "VARCHAR(200)", insertable = false, updatable = false, nullable = false)
	@Type(type = "uuid-char")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private UUID roleId;
	@Column(name = "role_name")
	private String roleName;
	@OneToMany(targetEntity = UserDto.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private List<UserDto> users;

	public RoleDto() {
		super();
	}

	public RoleDto(UUID roleId, String roleName, List<UserDto> users) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.users = users;
	}

	public UUID getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

}
