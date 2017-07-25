package introDuce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@192.168.0.77:1521:XE";
	private static final String USER = "book";
	private static final String PASSWORD = "book";
	
	public ConnectionFactory(){
		
	}
	
	/**
	 * DB 접속정보를 저장하는 Connection객체를 생성해서 반환
	 * @return
	 */
	public Connection createConnection(){
		
		try {
			// 드라이버 로딩 
			Class.forName(DRIVER_NAME);
		
			// DB 접속
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
		} catch(SQLException e){
			System.out.println("DB 접송 중 오류가 발생했습니다.");
		}
		return null;

	}
}

