package com.ty.personaddress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ty.personaddress.dto.Person;
import com.ty.personaddress.util.ConnectionObject;

public class PersonDao {
	public int savePerson(Person person) {
		String query="insert into person values(?,?,?,?)";
		Connection connection=ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, person.getPid());
			preparedStatement.setString(2, person.getName());
			preparedStatement.setString(3,person.getEmail());
			preparedStatement.setString(4, person.getPhone());
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return 0;
	}
}
