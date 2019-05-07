package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		// jdbc 6버전 이상에는 com.mysql.cj.jdbc.Driver로 써야한다
		String url = "jdbc:mysql://localhost:3306/sqldb?useSSL=false&characterEncoding=utf8";
		Connection con = null;
		Statement stmt = null;

		String hakbun, addr, phone;
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Member 테이블에  값 갱신하기.... ");

			System.out.println("갱신할 학번 입력 ");
			hakbun = br.readLine();
			System.out.println("갱신할 주소  입력 ");
			addr = br.readLine();
			System.out.println("갱신할 전화번호  입력 ");
			phone = br.readLine();
			String sql = "Update member Set addr =' " + addr;
			sql += "', phone = '" + phone + "' where hakbun = '";
			sql += hakbun + "' ";

			System.out.println(sql);

			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Update database success!!!");
		} catch (Exception e) {
			System.out.println("Update database failed!!!");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
