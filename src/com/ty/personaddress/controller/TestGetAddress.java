package com.ty.personaddress.controller;

import java.util.List;

import com.ty.personaddress.dto.Address;
import com.ty.personaddress.service.AddressService;

public class TestGetAddress {
	public static void main(String[] args) {
		AddressService addressService=new AddressService();
		List<Address> list=addressService.getAddress(2);
		if(list!=null)
			System.out.println(list);
		else
			System.out.println("No Address Found");
	}
}
