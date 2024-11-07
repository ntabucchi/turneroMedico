package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase Factoría de Conexiones SQL SERVER
 *
 */
public class DataSource {
	
	private static Connection connection;
	private static int anidamiento = 0;

	/**
	 * Obtiene una Conexion JDBC
	 * @return
	 */
	public static Connection obtenerConexion()
	{
		if(connection==null){
			try {
				String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
				String urldb = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=TurneroMedico";
				String user = "sa";
				String psw = "121186";
				
				Class.forName(driver);
				connection = DriverManager.getConnection(urldb,user,psw);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}else{
			anidamiento++;
			return connection;
		}
		return connection;
	}
	
	
	public static void cerrarConexion(){
		if(anidamiento==0){
			try {
				connection.close();
				connection=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			anidamiento--;
		}
	}
	
	public static void cerrarConexion(PreparedStatement stmt) {
		cerrarConexion(null,stmt);
	}


	
	public static void rollback() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void cerrarConexion(ResultSet resultSet, Statement stmt) {
		try{
			if(resultSet!=null){
				resultSet.close();
				resultSet=null;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try{
			if(stmt!=null){
				stmt.close();
				stmt = null;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		cerrarConexion();
	}

}
