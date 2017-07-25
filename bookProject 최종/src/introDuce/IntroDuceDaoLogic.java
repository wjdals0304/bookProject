package introDuce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class IntroDuceDaoLogic implements IntroDuceDao {

	@Override
	public List<IntroDuce> findAllList() {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<IntroDuce> intro = new ArrayList<>();
		
		try {
		ConnectionFactory factory = new ConnectionFactory();
		conn = factory.createConnection();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT INTRODUCEID, ROLE, NAME, FUNCTION ");
		sqlBuilder.append("FROM INTRODUCE_TB ");
		sqlBuilder.append("ORDER BY INTRODUCEID ");
		String sql = sqlBuilder.toString();
		
		pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			IntroDuce introduce = new IntroDuce();
			introduce.setIntroDuceId(rs.getString("INTRODUCEID"));
			introduce.setRole(rs.getString("ROLE"));
			introduce.setName(rs.getString("NAME"));
			introduce.setFunction(rs.getString("FUNCTION"));
			intro.add(introduce);
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
		System.out.println("자원반납중 오류가 발생했습니다.");
	}
		return intro;
	}

	@Override
	public void create(IntroDuce introDuce) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		ConnectionFactory factory = new ConnectionFactory();
		conn = factory.createConnection();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("INSERT INTO INTRODUCE_TB ");
		sqlBuilder.append("(ROLE, NAME, FUNCTION) ");
		sqlBuilder.append("VALUES (?, ?, ?) ");
		String sql = sqlBuilder.toString();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, introDuce.getRole());
		pstmt.setString(2, introDuce.getName());
		pstmt.setString(3, introDuce.getFunction());
		pstmt.executeUpdate();

		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 실행중 오류가 발생했습니다.");
		} finally{
			try{
				if(conn != null){conn.close();}
				if(pstmt != null){ pstmt.close();}
			} catch(SQLException e){
				e.printStackTrace();
				System.out.println("자원 반납중 오류가 발생했습니다.");
			}
		}
	}

	@Override
	public void delete(String introDuceId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		ConnectionFactory factory = new ConnectionFactory();
		conn = factory.createConnection();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("DELETE INTRODUCE_TB ");
		sqlBuilder.append("WHERE INTRODUCEID = ?");
		String sql = sqlBuilder.toString();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, introDuceId);
		pstmt.executeUpdate();

		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 실행중 오류가 발생했습니다.");
		} finally{
			try{
				if(conn != null){conn.close();}
				if(pstmt != null){ pstmt.close();}
			} catch(SQLException e){
				e.printStackTrace();
				System.out.println("자원 반납중 오류가 발생했습니다.");
			}
		}
	}

	@Override
	public void update(IntroDuce introDuce) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		ConnectionFactory factory = new ConnectionFactory();
		conn = factory.createConnection();
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" UPDATE INTRODUCE_TB ");
		sqlBuilder.append(" SET ROLE = ?, NAME = ?, FUNCTION = ? ");
		sqlBuilder.append(" WHERE introduceId = ? ");
		String sql = sqlBuilder.toString();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, introDuce.getRole());
		pstmt.setString(2, introDuce.getName());
		pstmt.setString(3, introDuce.getFunction());
		pstmt.setString(4, introDuce.getIntroDuceId());
		pstmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 실행중 오류가 발생했습니다.");
		} finally{
			try{
				if(conn != null){conn.close();}
				if(pstmt != null){ pstmt.close();}
			} catch(SQLException e){
				e.printStackTrace();
				System.out.println("자원 반납중 오류가 발생했습니다.");
			}
		}
	}

	@Override
	public IntroDuce find(String intro) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		IntroDuce introduce = new IntroDuce();
		try {
			
		ConnectionFactory factory = new ConnectionFactory();
		conn = factory.createConnection();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT INTRODUCEID, ROLE, NAME, FUNCTION ");
		sqlBuilder.append("FROM INTRODUCE_TB ");
		sqlBuilder.append("WHERE INTRODUCEID = ? ");
		String sql = sqlBuilder.toString();
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			introduce.setIntroDuceId(rs.getString("INTRODUCEID"));
			introduce.setRole(rs.getString("ROLE"));
			introduce.setName(rs.getString("NAME"));
			introduce.setFunction(rs.getString("FUNCTION"));
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
		System.out.println("자원반납중 오류가 발생했습니다.");
	}finally{
		try{
			if(conn != null){conn.close();}
			if(pstmt != null){ pstmt.close();}
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("자원 반납중 오류가 발생했습니다.");
		}
	}
		return introduce;
	}
}