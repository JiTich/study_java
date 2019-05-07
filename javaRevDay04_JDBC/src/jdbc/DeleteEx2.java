package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEx2 {

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sqldb?useSSL=false&characterEncoding=utf8";
		Connection con = null;
		//preparedStatement
		PreparedStatement ptmt = null;

		String sql = "delete from member where hakbun =?";
		String hakbun;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member table에 값 삭제하기  ........");
			System.out.println(" 학번 입력 : ");
			hakbun = br.readLine();

		
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			
			ptmt  =con.prepareStatement(sql);
			ptmt.setString(1, hakbun);
		
			ptmt.executeUpdate();
			System.out.println("delete database  success!!!");
		} catch (Exception e) {
			System.out.println("delete database  failed!!!");
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
