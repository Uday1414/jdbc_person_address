package com.ty.personaddress.controller;

import com.ty.personaddress.dto.Address;
import com.ty.personaddress.service.AddressService;

public class TestSaveAddress {
	public static void main(String[] args) {
		Address address=new Address();
		address.setAid(4);
		address.setStreet("marathahalli");
		address.setDoor_no("204");
		address.setCity("Bangalore");
		address.setPin(500101);
		
		AddressService addressService=new AddressService();
		int res= addressService.saveAddress(address, 2);
		if(res>0)
			System.out.println("Address saved");
		else
			System.out.println("Not Saved");
	}
}
