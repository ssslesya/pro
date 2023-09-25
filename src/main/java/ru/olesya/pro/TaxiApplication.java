package ru.olesya.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class TaxiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiApplication.class, args);

	}
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		String connectionUrl = "jdbc:sqlserver://DESKTOP-83VT9QA;"
//				+ "databaseName=taxi;"
//				+ "encrypt=true;"
//				+ "trustServerCertificate=true;"
//				+ "loginTimeout=5;";
//		try(Connection connection = DriverManager.getConnection(connectionUrl, "administrator", "taxi")){
//			Statement st = connection.createStatement();
////			st.execute("exec sp_setapprole 'Std', '123'");
////			st.executeUpdate("""
////                    insert drivers
////                    values ('Ряснов', 'Павел')
////                    """);
//			printSelect(st, "Select * from drivers");
//		} catch (Exception e){
//			throw new RuntimeException(e);
//		}
//	}
//	public static void printSelect(Statement st, String str) throws SQLException {
//		ResultSet res = st.executeQuery(str);
//		for(int i = 1; i <= res.getMetaData().getColumnCount(); i++){
//			System.out.printf(res.getMetaData().getColumnLabel(i)+"\t");
//		}
//		System.out.println("\n");
//
//		while(res.next()) {
//			for (int i = 1; i <= res.getMetaData().getColumnCount(); i++) {
//				System.out.print(res.getString(i) + "\t");
//			}
//			System.out.println();
//		}
//	}
//	public static void getAllNameTables(Connection connection) throws SQLException {
//		String[] types = {"TABLE"};
//		ResultSet rs = connection.getMetaData().getTables(null, null, "%", types);
//		while (rs.next()) {
//			System.out.println(rs.getString("TABLE_NAME"));
//		}
//	}
}