package sec01.jdbc;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;

public class project{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String[] grade = new String[100];
		String birth[]= new String[100];
		int score[] = new int[100];
		int age[]= new int[100];
		int ssal[]= new int[100];
		int count[] = new int[100];
		String ready1;
		int ready2;
		int max=0;
		int sum=0;
		int num=0;
		int avg=0;
		int stuc=0;
		String ID = null;
		String PW = null;
		boolean run=true;
		
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		String column="";
		
		Scanner sc = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,id,pw);
		String sql ="select * from emp";
		String ms ="select max(sal) from emp";
		String sa ="select sal from emp";
		String log ="select * from member";
		
		
		
		Statement stmt1 =con.createStatement();
		ResultSet rs1 = stmt1.executeQuery(sql);
		
		Statement stmt2 =con.createStatement();
		ResultSet rs2 = stmt2.executeQuery(ms);
		
		Statement stmt3 =con.createStatement();
		ResultSet rs3 = stmt3.executeQuery(sa);

		Statement stmt4 =con.createStatement();
		ResultSet rs4 = stmt4.executeQuery(log);
		
		System.out.printf("로그인 입력창\n------------------------------");

		while(rs4.next() && run==true) {
			String id1 = rs4.getString("id");
			String pw1 = rs4.getString("pw");
			
			System.out.println("아이디 입력");
			ID=sc.nextLine();
			System.out.println("비밀번호 입력");
			PW=sc.nextLine();
			
			
			if(ID.equals(id1) && PW.equals(pw1)) {
				System.out.println("1.이름\t2.나이\t3.등급\t4.생년월일");
				System.out.println("--------------------------------------");

					//학생 이름  ename
					while (rs1.next()) {
					String ename = rs1.getString("ename");	//학생값을 ename 안에 값을집어넣음 
					System.out.printf("%s\t",ename);

					num +=1;
					String hiredate = rs1.getString(5);
					//직원 등급 score[num]
					rs3.next();
					int sal = Integer.parseInt(rs3.getString("sal"));
					ssal[num]=sal;
					
					//직원 나이
					ready1=hiredate.substring(0, 4);
					ready2=Integer.parseInt(ready1);
					age[num]=2025-ready2;
					System.out.printf("%d\t",age[num]);
					
					//직원 등급
					if(ssal[num]>=5000) {
						grade[num]="A";
						System.out.printf("A");
					}else if(ssal[num]>=3000) {
						grade[num]="B";
						System.out.printf("B");
					}else if(ssal[num]<3000) {
						grade[num]="C";
						System.out.printf("C");
					}else if(ssal[num]<2000) {
						grade[num]="D";
						System.out.printf("D");
					}else {
						grade[num]="F";
						System.out.printf("F");
					}
					
					System.out.printf("\t");
					
					//학생 생년월일 hiredate
					System.out.printf(hiredate);
					System.out.printf("\t\n");
					}
					
					//직원 가장 높은 연봉값
					rs2.next();
					max = Integer.parseInt(rs2.getString("max(sal)"));
					System.out.printf("직원 중 가장 높은 연봉값 : %d\n",max);
					
					run=false;
					
					
					}else{
				System.out.println("종료합니다.");
				run=false;
				
				}
			
		}
		rs1.close();
		rs2.close();
		rs3.close();
		rs4.close();
		
		stmt1.close();
		stmt2.close();
		stmt3.close();
		stmt4.close();
		con.close();
	}
}

		

