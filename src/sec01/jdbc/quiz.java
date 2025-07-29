package sec01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class quiz {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String[] column=null;
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		String wcolumn="";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,id,pw);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("sql문 입력>");
		String sql = sc.nextLine();
		
		Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
	
		while(rs.next()) {
			String str1 = rs.getString(1);
			String str2 = rs.getString(2);
			String str3 = rs.getString(3);
			System.out.printf("%-10s\t%s\t%s\n", str1, str2, str3);
		}
		
		
		
//		while(rs.next()) {
//			for (int i=0; i>3; i++) {
//				column[i]=sc.nextLine();
//				System.out.println("칼럼 3개 입력");
//				wcolumn=sc.nextLine();
//				column[i]=rs.getString(wcolumn);
//				if(i>3) {
//					System.out.printf("%s\t%s\t%s\t",column[i]);
//				}
//			}
//		}
		
		rs.close();
		stmt.close();
		con.close();
	}

}
