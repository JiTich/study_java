package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Ex01 {

	public static void main(String[] args) {
		// 예외를 잘 처리하기위해서 선언문을 밖으로 뺌

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// jdbc 6버전 이상에는 com.mysql.cj.jdbc.Driver로 써야한다
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb?useSSL=false", "root", "1234");
			// statement 객체 저장
			stmt = conn.createStatement();
			// sql구문이 select 일때
			rs = stmt.executeQuery("select code, name, price, maker from goodsinfo;");
			System.out.println("  상품코드            상품명  \t\t 	가격     	제조사");
			System.out.println("----------------------------------------------------");
			while (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s		%8s \t %12d     %s\n", code, name, price, maker);
			}
		} catch (ClassNotFoundException ec) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + ec.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Exception ignored) {
				// TODO: handle exception
			}
			try {
				conn.close();
			} catch (Exception ignored) {
			}
			try {
				rs.close();
			} catch (Exception ignored) {
			}
		}
	}

	private static String toUnicode(String str) {
		try {
			byte[] b = str.getBytes("ISO-8859-1");
		} catch (Exception e) {

		}
		return "";
	}
}
