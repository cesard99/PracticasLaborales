package utils.service;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.dto.FirmaDigital_DTO;


public class FirmaDigital_Service {
    
public void insertText(String text, String firma,int usuario,String privatekey,String publickey) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT text_insert(?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(2, text);
		preparedStatement.setString(3, firma);
        preparedStatement.setInt(4, usuario);
		preparedStatement.setString(5, privatekey);
		preparedStatement.setString(6, publickey);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

    public ArrayList<FirmaDigital_DTO> selectAllTexts() throws SQLException, ClassNotFoundException{
		ArrayList<FirmaDigital_DTO> text = new ArrayList<FirmaDigital_DTO>();
		String function = "{?= call select_all_text()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			text.add(new FirmaDigital_DTO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5),rs.getString(6)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return text;
	}

}
