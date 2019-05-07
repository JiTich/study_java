package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteEx {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      String driver = "com.mysql.jdbc.Driver";
      String url =
            "jdbc:mysql://localhost:3306/sqldb?useSSL=false&characterEncoding=utf8";
      Connection conn = null;
      Statement stmt = null;
      
      String hakbun=null;
      
      try {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("삭제할 학번을 입력하세요");
         
         hakbun = br.readLine();
         String sql = "Delete from member where hakbun='"+hakbun+"'";
         Class.forName(driver);
         conn= DriverManager.getConnection(url,"root","1234");
         stmt= conn.createStatement();
         stmt.execute(sql);
         
         System.out.println("DB 삭제 완료!");
         
         
         
      }
      catch(Exception e) {
         System.out.println("db연결실패!"+e.getMessage());
         
      }
   
      finally {
         try {
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
         }
         catch(Exception e) {
            
         }
      }
   
   }

}