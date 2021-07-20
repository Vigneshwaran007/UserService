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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_table")
public class UserDto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type="uuid-char")
	@Column(name = "user_id", columnDefinition = "VARCHAR(255)")
	private UUID userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="role_id")
	@Type(type="uuid-char")
	private UUID roleId;
	@Column(name="created_time")
	@CreationTimestamp
	private Date createdTime;
	@Column(name="last_updated_time")
	@UpdateTimestamp
	private Date lastUpdatedTime;

}
