package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectEx {
//Using  sqldb-Member Table
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		// jdbc 6버전 이상에는 com.mysql.cj.jdbc.Driver로 써야한다
		String url = "jdbc:mysql://localhost:3306/sqldb?useSSL=false";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "Select * From member";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("hakbun \t name \t addr \t phone");
			System.out.println("--------------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getString("hakbun") + "   \t ");
				System.out.print(rs.getString("name") + "  \t ");
				System.out.print(rs.getString("addr") + "  \t ");
				System.out.print(rs.getString("phone") + "\n");

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("database connection failed!!!");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
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
