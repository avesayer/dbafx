package com.msokolov.model;

public class Environment {
	
	private String name;
	private String sqlServer;
	private String port;
	private String user;
	private String password;

	public Environment(String name, String sqlServer, String port, String user, String password) {
		this.name = name;
		this.sqlServer = sqlServer;
		this.port = port;
		this.user = user;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSqlServer() {
		return sqlServer;
	}
	public void setSqlServer(String sqlServer) {
		this.sqlServer = sqlServer;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Environment [name=" + name + ", password=" + password + ", port=" + port + ", sqlServer=" + sqlServer
				+ ", user=" + user + "]";
	}
}
