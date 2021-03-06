package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertEx2 {
//Using  sqldb-Member Table

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sqldb?useSSL=false&characterEncoding=utf8";
		Connection con = null;
		//preparedStatement
		PreparedStatement ptmt = null;

		String sql = "Insert Into member(hakbun, name, addr, phone) Values (?,?,?,?)";
		String hakbun, name, addr, phone;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member table에 값 추가하기  ........");
			System.out.println(" 학번 입력 : ");
			hakbun = br.readLine();
			System.out.println(" 이름 입력 : ");
			name = br.readLine();
			System.out.println(" 주소 입력 : ");
			addr = br.readLine();
			System.out.println(" 전화번호 입력 : ");
			phone = br.readLine();

		
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			
			ptmt  =con.prepareStatement(sql);
			ptmt.setString(1, hakbun);
			ptmt.setString(2, name);
			ptmt.setString(3, addr);
			ptmt.setString(4, phone);
		
			ptmt.executeUpdate();
			System.out.println("database connection success!!!");
		} catch (Exception e) {
			System.out.println("database connection failed!!!");
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

}
