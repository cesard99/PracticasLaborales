package utils.service;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.dto.Registrer_DTO;





public class Registrer_Services {
	public void insertUser(String usser, String userpass) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT usser_insert(?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		userpass=Encription.encode(Definicion.SECRET_KEY_PASSWORD, userpass);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, usser);
		preparedStatement.setString(2, userpass);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void deleteUser(int userCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT users__delete(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void updateUser(String usser, String userpass, String rol, int code) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT users__update(?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		userpass=Encription.encode(Definicion.SECRET_KEY_PASSWORD, userpass);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, usser);
		preparedStatement.setString(2, userpass);
		preparedStatement.setString(3, rol);
		preparedStatement.setInt(4, code);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void updateUserWithoutPassword(int userCode, String userName, String userNick, int roleCode) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT users__update_without_password(?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userCode);
		preparedStatement.setString(2, userName);
		preparedStatement.setString(3, userNick);
		preparedStatement.setInt(4, roleCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public Registrer_DTO findUser(int userCode) throws SQLException, ClassNotFoundException{
		java.sql.Connection connection = ServicesLocator.getConnection();
		Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
		String query = "SELECT * FROM users_ WHERE users_.users_code = '"+userCode+"'"; 
		ResultSet rs = statement.executeQuery(query);
		rs.first();
		Registrer_DTO user = new Registrer_DTO(rs.getString(1), rs.getString(2),rs.getInt(3));
		rs.close();
		statement.close();
		connection.close();
		return user;
	}
	
	public ArrayList<Registrer_DTO> selectAllUsers() throws SQLException, ClassNotFoundException{
		ArrayList<Registrer_DTO> users = new ArrayList<Registrer_DTO>();
		String function = "{?= call select_all_usser()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			users.add(new Registrer_DTO(rs.getString(1), rs.getString(2),rs.getInt(3)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return users;
	}
}