package utils.service;
import java.sql.SQLException;
import utils.conectiondtb.*;


public class ServicesLocator {
	
	public static Registrer_Services registrer_Services = null;
	public static FirmaDigital_Service firmaDigital_Service= null;

	public static FirmaDigital_Service getFirmaDigital_Service(){
		if(firmaDigital_Service==null)
			firmaDigital_Service = new FirmaDigital_Service();
		return firmaDigital_Service;
	}
	
	
	public static Registrer_Services getRegistrer_Services(){
		if(registrer_Services == null)
			registrer_Services = new Registrer_Services() ;
		return registrer_Services;
	}
	
	
	
	public static java.sql.Connection getConnection(){
		Connection connection = null;
		try {
			connection = new Connection("localhost", "PL", "postgres", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection.getConnection();
	}
	
	
	
}