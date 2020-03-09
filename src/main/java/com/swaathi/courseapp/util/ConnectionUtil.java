package com.swaathi.courseapp.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {
	private static final Logger LOGGER = Logger.getInstance();
	public static  Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LOGGER.debug(e);
		}
		//String server = "CSLH2024";
		//return (DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE","swaathi","swaathi"));
		return (DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle"));
	}
	
}