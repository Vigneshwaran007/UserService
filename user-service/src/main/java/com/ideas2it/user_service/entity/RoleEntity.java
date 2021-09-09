package com.ideas2it.user_service.entity;

import java.util.List;
import java.util.UUID;

/**
 * RoleEntity which represent entity for Role table entity.
 * 
 * @author Vigneshwaran N
 */

public class RoleEntity {

	private UUID roleId;
	private String roleName;
	private List<UserEntity> users;

	public RoleEntity() {
		super();
	}

	private RoleEntity(RoleBuilder roleBuilder) {
		super();
		this.roleId = roleBuilder.roleId;
		this.roleName = roleBuilder.roleName;
		this.users = roleBuilder.users;
	}

	public UUID getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public static class RoleBuilder {
		private UUID roleId;
		private String roleName;
		private List<UserEntity> users;

		public RoleBuilder roleId(UUID roleId) {
			this.roleId = roleId;
			return this;
		}

		public RoleBuilder roleName(String roleName) {
			this.roleName = roleName;
			return this;
		}

		public RoleBuilder users(List<UserEntity> users) {
			this.users = users;
			return this;
		}

		public RoleEntity build() {
			RoleEntity roleEntity = new RoleEntity(this);
			return roleEntity;
		}
	}

}