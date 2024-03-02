package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    public static Connection getConnection()
        {
            Connection connection = null;
            try
            {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/firma", "postgres", "1234");
                System.out.println("Conection correct");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            return connection;
        }
}
