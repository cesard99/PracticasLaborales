package utils.conectiondtb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class TestConnection {
	
	
    public static void main(String[] args) {
        
    	String url = "jdbc:postgresql://localhost:5432/PL";
        String user = "postgres";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexi�n exitosa a la base de datos PostgreSQL");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos PostgreSQL: " + e.getMessage());
        }

    }
        
        
        
        
     	
    
}

//("localhost", "ProyectoEleccion", "postgres", "dejesusraul"); 1234