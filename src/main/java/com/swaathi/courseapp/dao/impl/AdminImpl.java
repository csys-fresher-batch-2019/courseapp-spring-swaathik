package com.swaathi.courseapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swaathi.courseapp.controller.IndexController;
import com.swaathi.courseapp.dao.AdminDAO;
import com.swaathi.courseapp.util.ConnectionUtil;

@Repository

	public class AdminImpl implements AdminDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

		public String login(String adminName, String passWord) throws SQLException {
			String sql = "select admin_name,admin_password from admin_table where adminname='" + adminName + "' and password='"+ passWord + "'";
			try(Connection connection = ConnectionUtil.getConnection();
					Statement stmt = connection.createStatement();){
				try(ResultSet rs = stmt.executeQuery(sql)){
			Logger.debug(sql);
			String st=null;
			if (rs.next()) {
			st="success";
			String adminName1 = rs.getString("admin_name");
			//LOGGER.debug(adminName1);
			String Password = rs.getString("admin_password");
			//LOGGER.debug(Password);
			if (adminName.equals(adminName1) && passWord.equals(Password)) 
			{

			Logger.debug("Login Successfull");
			return st;
			
			} 

			}
			else 
			{
			st="failed";
			Logger.debug("Login failed");
			return st;
			}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			Logger.debug(e.getMessage());
			}
			return null;
			} 
			}

	}
