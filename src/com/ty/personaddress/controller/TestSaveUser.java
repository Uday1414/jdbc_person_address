package com.ty.personaddress.controller;

import com.ty.personaddress.dto.Person;
import com.ty.personaddress.service.PersonService;

public class TestSaveUser {
	public static void main(String[] args) {
		
		Person person=new Person();
		person.setPid(2);
		person.setName("abhi");
		person.setEmail("abhi@mail.com");
		person.setPhone("1234569874");
		
		PersonService personService=new PersonService();
		int res=personService.savePerson(person);
		if(res>0)
			System.out.println("Person saved");
		else
			System.out.println("Not saved");
		
	}
}
