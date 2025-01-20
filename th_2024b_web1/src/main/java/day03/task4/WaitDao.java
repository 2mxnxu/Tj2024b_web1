package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day03.task3.VisitDto;

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
					"jdbc:mysql://localhost:3306/mydb0120",
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
	public ArrayList<WaitDto> findAll() {
		ArrayList<WaitDto> list = new ArrayList<WaitDto>();
		try {
			String sql = "select * from waitting";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				WaitDto waitDto = new WaitDto();
				waitDto.setCallnum(rs.getString("callnum"));
				waitDto.setPerson(rs.getInt("person"));
				waitDto.setNum(rs.getInt("num"));
				list.add(waitDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	public boolean update(WaitDto waitDto) {
		try {
			String sql = "update waitting set callnum = ? , person = ? where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitDto.getCallnum());
			ps.setInt(2, waitDto.getPerson());
			ps.setInt(3, waitDto.getNum());
			int count = ps.executeUpdate();
			if(count == 1) {
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
}
