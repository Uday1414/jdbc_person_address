package com.ty.personaddress.controller;

import com.ty.personaddress.service.AddressService;

public class TestDeleteAddress {
	public static void main(String[] args) {
		AddressService addressService=new AddressService();
		int res=addressService.deleteAddress(2);
		System.out.println(res);
		if(res>0)
			System.out.println("Address deleted");
		else
			System.out.println("No address found");
	}
}
