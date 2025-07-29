package sec01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTest1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con =null;
		String sql = "select * from emp";	//emp 테이블중 ename 컬럼 가져온것

		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("클래스 있다.");
		
		con = DriverManager.getConnection(url, id, pw);
		System.out.println("접속 성공!");
		
		Statement stmt = con.createStatement();		//createStatement()는SQL 명령을 실행할 수 있는 Statement 객체 
		ResultSet rs = stmt.executeQuery(sql);		//전달한 SQL 문(sql)을 실행하고,그 결과를 ResultSet 객체에 담아 반환
		
		System.out.println("이름\t직무");
		System.out.println("----------------");
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			String str = rs.getString(5);
			System.out.printf("%s\t%s\t%s\t\t%s\n",empno,ename,job,str);
		}
		rs.close();
		stmt.close();
		con.close();	//close()3가지 꼭 해야됨 rs,stmt,con 열고 닫기 습관화 해야함!!!
		

		
		
//		rs.next(); 테이블에 가장 먼저 있는 걸 가르켜라 반복문을 이용하게 되면 그다음 것을 가르킨다.								
//		rs.next(); 끝까지 가게 되면 false를 반환함
//		String ename = rs.getString("ename");		//ename 테이블에 데이터를 가져와라
//		System.out.println(ename);					//ename 결과가 SMITH
		
		
		
		
		
//		try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("클래스 있다");
//	} catch (ClassNotFoundException e) {
//		System.out.println("클래스 없다");
//		e.printStackTrace();
//	}

	}

}
