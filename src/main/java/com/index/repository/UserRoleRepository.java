package com.index.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.index.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long>{

	@Query("select a.role from UserRole a, User b where b.username=?1 and a.userId = b.userId")
	public UserRole findRoleByUserName(String username);
	
}
