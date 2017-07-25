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
	 * DB ���������� �����ϴ� Connection��ü�� �����ؼ� ��ȯ
	 * @return
	 */
	public Connection createConnection(){
		
		try {
			// ����̹� �ε� 
			Class.forName(DRIVER_NAME);
		
			// DB ����
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� Ŭ������ ã�� �� �����ϴ�.");
		} catch(SQLException e){
			System.out.println("DB ���� �� ������ �߻��߽��ϴ�.");
		}
		return null;

	}
}

