package org.youngweb.model;

import org.young.model.Entity;

public class User extends Entity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String work;
	private String password;

	public String getWork() {
		return work;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
