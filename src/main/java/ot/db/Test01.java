package ot.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ot.utils.Basic;

public class Test01 extends Basic{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		out("start");
		test01();
		out("end");
	}

	private static void test01() {
	     try {
	    	 // JDK6以降は不要？
//	         Class.forName("org.postgresql.Driver");

     	     //接続文字列
		     String url = "jdbc:postgresql://localhost:5433/test";
		     String user = "postgres";
		     String password = "Administrator";
	         try(Connection conn = DriverManager.getConnection(url, user, password)){
		         //自動コミットOFF
		         conn.setAutoCommit(false);

		         //SELECT文の実行
		         try(Statement stmt = conn.createStatement()){
			         //INSERT文の実行
			         String sql = "INSERT INTO t01(text) VALUES ('sample')";
			         stmt.executeUpdate(sql);
			         conn.commit();

			         sql = "SELECT * FROM t01";
			         try(ResultSet rset = stmt.executeQuery(sql)){
				         //SELECT結果の受け取り
				         while(rset.next()){
				             String col = rset.getString(1);
				             System.out.println(col);
				         }
			         }
		         }
	         }
	     }
//	     catch (ClassNotFoundException e) {
//	         e.printStackTrace();
//	     }
	     catch (SQLException e){
	         e.printStackTrace();
	     }
	 }
}
