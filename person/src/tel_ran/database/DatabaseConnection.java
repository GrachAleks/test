package tel_ran.database;
import java.sql.*;
public class DatabaseConnection {
private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
private static final String URL_DB_TEST="jdbc:mysql://localhost/test";
private static DatabaseConnection dbc=null;
private  Statement statement;
private DatabaseConnection (String url,String username, String password) throws ClassNotFoundException, SQLException{
	Class.forName(DRIVER_NAME);
	Connection connection=DriverManager.getConnection(url,username,password);
	statement=connection.createStatement();
}
public static Statement getDatabaseConnection(String username, String password) throws ClassNotFoundException, SQLException{
	if(dbc==null){
		dbc=new DatabaseConnection(URL_DB_TEST, username, password);
	}
	return dbc.statement;
	
}
public static Statement getDatabaseConnection(String url,String username, String password) throws ClassNotFoundException, SQLException{
	if(dbc==null){
		dbc=new DatabaseConnection(url, username, password);
	}
	return dbc.statement;
}
}
