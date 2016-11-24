package com.index.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cats")
public class Cat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String owner;
	private Date birth;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getOwner() {
		return owner;
	}
	public Date getBirth() {
		return birth;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
}
