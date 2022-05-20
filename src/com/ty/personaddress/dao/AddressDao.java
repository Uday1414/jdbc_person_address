package com.ty.personaddress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.personaddress.dto.Address;
import com.ty.personaddress.util.ConnectionObject;


public class AddressDao {
	public int saveAddress(Address address,int pid) {
		String query="insert into address values(?,?,?,?,?,?)";
		
		Connection connection=ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(6, pid);
			preparedStatement.setInt(1, address.getAid());
			preparedStatement.setString(2, address.getStreet());
			preparedStatement.setString(3,address.getDoor_no());
			preparedStatement.setString(4, address.getCity());
			preparedStatement.setInt(5, address.getPin());
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	public List<Address> getAddress(int pid){
		String query="SELECT * FROM address where pid=?";
		Connection connection=ConnectionObject.getConnection();
		ArrayList<Address> arrayList=new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, pid);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Address address=new Address();
				address.setAid(resultSet.getInt(1));
				address.setStreet(resultSet.getString(2));
				address.setDoor_no(resultSet.getString(3));
				address.setCity(resultSet.getString(4));
				address.setPin(resultSet.getInt(5));
				
				arrayList.add(address);
			}
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
		return arrayList;
	}
	
	public int deleteAddress(int pid) {
		String query="DELETE FROM address WHERE pid=?";
		
		Connection connection=ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, pid);
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
