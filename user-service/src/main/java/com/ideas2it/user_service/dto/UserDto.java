package com.ideas2it.user_service.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * UserDto represent User table.
 * 
 * @author Vigneshwaran N
 *
 */
@Entity
@Table(name = "user_table")
public class UserDto {

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", password=" + password + ", roleId=" + roleId
				+ ", createdTime=" + createdTime + ", lastUpdatedTime=" + lastUpdatedTime + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "user_id", columnDefinition = "VARCHAR(255)")
	private UUID userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "role_id", columnDefinition = "VARCHAR(255)")
	@Type(type = "uuid-char")
	private UUID roleId;
	@Column(name = "created_time")
	@CreationTimestamp
	private Date createdTime;
	@Column(name = "last_updated_time")
	@UpdateTimestamp
	private Date lastUpdatedTime;

	public UserDto() {
		super();
	}

	public UserDto(UUID userId, String userName, String password, UUID roleId, Date createdTime, Date lastUpdatedTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.createdTime = createdTime;
		this.lastUpdatedTime = lastUpdatedTime;
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

}
