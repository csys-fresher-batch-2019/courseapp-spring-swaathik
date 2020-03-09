package com.swaathi.courseapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.springframework.stereotype.Service;

import com.swaathi.courseapp.domain.StudentClass;
import com.swaathi.courseapp.util.ConnectionUtil;
import com.swaathi.courseapp.util.Logger;

@Service
public class UserService {
	private static final Logger LOGGER = Logger.getInstance();
	public static boolean login(StudentClass user)  {
		try(Connection con = ConnectionUtil.getConnection();CallableStatement stmt=con.prepareCall("{call login_procedure(?,?,?)}")) {
			stmt.setString(1,user.getUserName());
			stmt.setString(2, user.getPassWord());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			String status=stmt.getString(3);
			LOGGER.info("Status = "+status);
			if(status.equals("Success")) {
			LOGGER.debug("Logged In");
			return true;
			}
			else {
			LOGGER.debug("Logged out");
			return false;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return false;

		}
		}

