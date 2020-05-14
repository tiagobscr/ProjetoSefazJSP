package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBase1 {
	
	public static Connection getConncetion() {
		
		try {
			
			String sqlDriver = "org.hsqldb.jdbcDriver";
			String url = "jdbc:hsqldb:file:C:\\dbProjetoSefaz\\baseDesafioSefaz";
			String user = "sa";
			String senha = "";
			
			Class.forName(sqlDriver);
			Connection conn = DriverManager.getConnection(url,user,senha);
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
