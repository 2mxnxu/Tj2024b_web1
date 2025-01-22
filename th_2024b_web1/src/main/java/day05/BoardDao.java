package day05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	private Connection conn;
	private static BoardDao instance = new BoardDao();
	private BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0122",
					"root" , "1234");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static BoardDao getInstance() {
		return instance;
	}
	public boolean write(BoardDto boardDto) {
		try {
			String sql = "insert into post(title,content,writer,pwd)values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getContent());
			ps.setString(3, boardDto.getWriter());
			ps.setString(4, boardDto.getPwd());
			int count = ps.executeUpdate();
			if(count == 1) {
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
		
	}
	public ArrayList<BoardDto> findAll() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select * from post";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setPwd(rs.getString("pwd"));
				boardDto.setDdate(rs.getString("ddate"));
				boardDto.setViewnum(rs.getInt("viewnum"));
				boardDto.setNum(rs.getInt("num"));
				list.add(boardDto);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	public BoardDto findById( int num ) {
        try {
                String sql = "select * from post where num = ? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt( 1 , num);
                ResultSet rs = ps.executeQuery();
                if( rs.next() ) {
                        BoardDto boardDto = new BoardDto();
                        boardDto.setNum( rs.getInt( "num" ));
                        boardDto.setTitle( rs.getString("title") );
                        boardDto.setWriter( rs.getString( "writer" ));
                        boardDto.setDdate( rs.getString( "ddate" ));
                        boardDto.setViewnum( rs.getInt( "viewnum" ));
                        boardDto.setContent( rs.getString("content") );
                        boardDto.setPwd( rs.getString("pwd"));
                        return boardDto;
                }
        }catch(Exception e ) { System.out.println(e);}
        return null;
}
	
	public boolean update(BoardDto boardDto) {
		try {
			String sql = "update post set title = ?, content = ?, writer = ?, pwd = ? where num = ?"; 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getContent());
			ps.setString(3, boardDto.getWriter());
			ps.setString(4, boardDto.getPwd());
			ps.setInt(5, boardDto.getNum());
			int count = ps.executeUpdate();
			if(count == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	
	}
	public boolean delete(int num) {
		try {
			String sql = "delete from post where num =? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch (SQLException e) {
			System.out.println(e);
		}return false;
	}

}
