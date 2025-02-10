package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE) // private 디폴트 생성자 가 자동 생성 
public class BoardDao extends Dao {

	@Getter // 싱글톤을 반환하는 메소드를 자동 생성 , getInstance() 자동 생성  
	private static BoardDao instance = new BoardDao();

	// [1] 글쓰기 write SQL 메소드 
	public boolean write( BoardDto boardDto ) {
		try {
			String sql = "insert into board( btitle , bcontent , mno , cno )values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent() );
			ps.setInt( 3 , boardDto.getMno() );
			ps.setInt( 4 , boardDto.getCno() );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( Exception e ) {
			System.out.println(e );
		}
		return false;
	}
	
	// [2] 게시물 전체 조회 findAll SQL 메소드 
	public ArrayList< BoardDto > findAll( int cno ){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			// (1) 게시물 테이블 의 모든 속성을 전체 조회 
			// String sql =" select * from board ";
			// (2) 게시물 테이블 의 모든 속성과 회원 테이블의 mid 속성도 조회 , inner join : 다른 테이블과 같이 조회할때 , 조인 조건 주로 : pk-fk
			// 조인 : select * from 테이블A inner join 테이블B on 테이블A.PK필드명 = 테이블B.FK필드명;
			// 정렬 : order by 필드명 desc=내림차순 , asc=오름차순  
			// String sql = " select * from board b inner join member m on b.mno = m.mno order by b.bno desc";
			// (3) + 카테고리별 출력 , cno 조건추가 
			String sql = " select * from board b inner join member m on b.mno = m.mno "
					+ " where cno = ? "
					+ " order by b.bno desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , cno );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt("bno") );
				boardDto.setBtitle( rs.getString("btitle") );
				boardDto.setBcontent( rs.getString( "bcontent") );
				boardDto.setBdate( rs.getString("bdate"));
				boardDto.setBview( rs.getInt( "bview"));
				boardDto.setMno( rs.getInt("mno"));
				boardDto.setCno( rs.getInt("cno"));
				boardDto.setMid( rs.getString("mid") ); // 회원테이블과 조인 한 결과 회원아이디 도 조회 가능하다.
				list.add(boardDto);
			}
		}catch (Exception e) {System.out.println(e);}
		return list; 
	} // f end 
	
	// [3] 게시물 개별 삭제 delete SQL 메소드 
	public boolean delete( int bno ) {
		try {
			String sql ="delete from board where bno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( Exception e ) { System.out.println( e );}
		return false;
	} // f end 
	
	// [4] 게시물 개별 수정 update SQL 메소드 
	public boolean update( BoardDto boardDto ) {
		try {
			String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent() );
			ps.setInt( 3 , boardDto.getBno() );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch(Exception e ) { System.out.println( e );}
		return false;
	}
	
	// [5] 게시물 개별 조회 findByBno SQL 메소드 
	public BoardDto findByBno( int bno ) {
		try {
			// (1) 특정 게시물 테이블의 게시물 1개 조회 
			// String sql = "select * from board where bno = ? ";
			// (2) 게시물 테이블과 회원 테이블 교집합 구해서 회원아이디로 조회 가능
			// String sql = "select * from board b inner join member m on b.mno = m.mno";
			// (3) 게시물 테이블과 회원 테이블 과 카테고리 테이블 교집합 구해서 회원아이디 와 카테고리명 조회 가능 
			String sql = "select * from board b "
					+ " inner join member m on b.mno = m.mno "
					+ " inner join category c on b.cno = c.cno "
					+ " where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt("bno") );
				boardDto.setBtitle( rs.getString("btitle") );
				boardDto.setBcontent( rs.getString( "bcontent") );
				boardDto.setBdate( rs.getString("bdate"));
				boardDto.setBview( rs.getInt( "bview"));
				boardDto.setMno( rs.getInt("mno"));
				boardDto.setCno( rs.getInt("cno"));
				boardDto.setMid( rs.getString("mid") ); // 회원테이블과 조인 한 결과 회원아이디 도 조회 가능하다.
				boardDto.setCname( rs.getString( "cname") ); // 카테고리테이블 과 조인 한 결과 카테고리명 도 조회 가능하다.
				return boardDto;
			}
		}catch (Exception e) { System.out.println(e);}
		return null;
	}
} // class end 