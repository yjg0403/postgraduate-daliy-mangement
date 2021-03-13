package com.yjg123.projectmanager.domain;

/**
 * 用户实体类
 * @author dell
 */
public class Admin {
	private String username;
	private String password;
	private String depart;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", depart='" + depart + '\'' +
				'}';
	}
}
