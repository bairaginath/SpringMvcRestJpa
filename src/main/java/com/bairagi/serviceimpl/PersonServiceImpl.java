package com.bairagi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bairagi.common.Person;
import com.bairagi.dao.PersonDAO;
import com.bairagi.service.PersonService;



@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	


	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

}
