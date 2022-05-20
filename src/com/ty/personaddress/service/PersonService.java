package com.ty.personaddress.service;

import com.ty.personaddress.dao.PersonDao;
import com.ty.personaddress.dto.Person;

public class PersonService {
	PersonDao personDao=new PersonDao();
	public int savePerson(Person person) {
		return personDao.savePerson(person);
	}
}
