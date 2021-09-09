package com.ideas2it.user_service.entity;

import java.util.Date;
import java.util.UUID;

/**
 * UserEntity which represent entity for User table.
 * 
 * @author Vigneshwaran N
 */

public class UserEntity {
	private UUID userId;
	private String userName;
	private String password;
	private UUID roleId;
	private Date createdTime;
	private Date lastUpdatedTime;

	public UserEntity(UUID userId, String userName, String password, UUID roleId, Date createdTime,
			Date lastUpdatedTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.createdTime = createdTime;
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public UserEntity() {
		super();
	}

	private UserEntity(UserBuilder builder) {
		this.userId = builder.userId;
		this.userName = builder.userName;
		this.password = builder.password;
		this.roleId = builder.roleId;
		this.createdTime = builder.createdTime;
		this.lastUpdatedTime = builder.lastUpdatedTime;

	}

	public UUID getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public UUID getRoleId() {
		return roleId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public static class UserBuilder {
		private UUID userId;
		private String userName;
		private String password;
		private UUID roleId;
		private Date createdTime;
		private Date lastUpdatedTime;

		public UserBuilder userId(UUID userId) {
			this.userId = userId;
			return this;
		}

		public UserBuilder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder roleId(UUID roleId) {
			this.roleId = roleId;
			return this;
		}

		public UserBuilder createdTime(Date createdTime) {
			this.createdTime = createdTime;
			return this;
		}

		public UserBuilder lastUpdatedTime(Date lastUpdatedTime) {
			this.lastUpdatedTime = lastUpdatedTime;
			return this;
		}

		public UserEntity build() {
			UserEntity userEntity = new UserEntity(this);
			return userEntity;
		}
	}
}
