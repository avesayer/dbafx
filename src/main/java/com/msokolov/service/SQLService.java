package com.msokolov.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msokolov.model.File;

import fisglobal.jdbc.driver.ScDriver;

public class SQLService {
	
	private static final String driverName = "fisglobal.jdbc.driver.ScDriver";

	private String address;
    private String username;
    private String password;
    private String port;
	private String url;

	private Connection connection;

	public SQLService() {}
    public SQLService(String address, String port, String username, String password)
		throws NullPointerException
    {
		this.address  = address;
		this.port     = port;
		this.username = username;
		this.password = password;
		
		this.url = "jdbc=jdbc:fisglobal/database=" + address + ":" + port + ":SCA$IBS/locale=US:ENGLISH/timeOut=30/transType=MTM/rowPrefetch=30/signOnType=1/encryption=MD5/processMRPC=0/fileEncoding=UTF-8";
    }

	public void connect() throws ClassNotFoundException, SQLException
	{
		Class.forName(driverName);
        ScDriver driver = new ScDriver();
		DriverManager.registerDriver(driver);
		DriverManager.setLoginTimeout(10);
		connection = DriverManager.getConnection(this.url, this.username, this.password);
	}

	public List<File> getFileList() throws SQLException {
		List<File> result = new ArrayList<>();

		String sql = "SELECT FID, ACCKEYS, DES, GLREF, GLOBAL, LISTDFT, LISTREQ, LTD, USER FROM DBTBL1 ORDER BY FID";

		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setFetchSize(4000);

		ResultSet resultSet = prep.executeQuery();
		while(resultSet.next()) {
			result.add(new File(resultSet.getString(1),	// File Name
								resultSet.getString(2),	// Primary Keys
								resultSet.getString(3),	// Description
								resultSet.getString(4),	// Global Name
								resultSet.getString(5),	// Global Reference
								resultSet.getString(6),	// Default Data Item List
								resultSet.getString(7),	// Required Data Item List
								resultSet.getString(8),	// Last Updated
								resultSet.getString(9),	// User ID
								"")); 	// File Documentation
		}

		return result;
	}
}
