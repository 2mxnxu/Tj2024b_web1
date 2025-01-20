package day03.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitDao {
	private Connection conn;
	// + 싱글톤 
	private static WaitDao instance = new WaitDao();
	private WaitDao() {
		try {
			// DB연동 코드 : 
			// 코드 작성전에 필수 : 프로젝트의 mysql-connector-j-9.1.0.jar
			// 라이브러리 폴더 경로 : src -> main -> webapp -> web-inf -> lib 
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb1111",
					"root" , "1234");
		}catch( Exception e ) { System.out.println(e); }
		
	}
	public static WaitDao getInstance() { return instance; }
	
	public boolean write( WaitDto waitDto ) {
		try {
			String sql = "insert into waitting(callnum,person)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , waitDto.getCallnum());
			ps.setInt( 2 , waitDto.getPerson());
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( SQLException e ) { System.out.println(e); e.printStackTrace();}
			
		return false;
	} 
	public boolean delete(int num) {
		try {
		String sql = "delete from waitting where num =? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt( 1 , num );
		int count = ps.executeUpdate();
		if( count == 1 ) return true;
	}catch (Exception e) {
		System.out.println(e);
	}return false;
	}
	
}
