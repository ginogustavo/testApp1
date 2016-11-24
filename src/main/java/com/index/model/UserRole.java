package com.index.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
	private Long userRoleId;
	@Column(name = "userid")
	private Long userId;
	@Column(name = "role")
	private String role;
	
	public Long getUserRoleId() {
		return userRoleId;
	}
	public Long getUserId() {
		return userId;
	}
	public String getRole() {
		return role;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
