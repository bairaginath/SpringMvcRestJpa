package com.bairagi.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.stereotype.Repository;

import com.bairagi.common.Person;
import com.bairagi.dao.PersonDAO;
import com.bairagi.singleton.MyEntityManagerFactory;


@Repository
public class PersonDAOImpl extends MyEntityManagerFactory implements PersonDAO {
	
	

	
	

	
	public void addPerson(Person person) {
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction( ).begin( );
		entityManager.persist(person);
		entityManager.getTransaction( ).commit( );
	    //entityManager.close( );
		
	}

	
	public void updatePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction( ).begin( );		
		entityManager.merge(person);
		entityManager.getTransaction( ).commit( );
	   // entityManager.close( );	   
		
	}

	
	public List<Person> listPersons() {
		EntityManager entityManager=getEntityManager();
		List<Person> personList=entityManager.createQuery("from Person").getResultList();
		//entityManager.close();
		return personList;
	}

	
	public Person getPersonById(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class,id);
		//entityManager.close();
		return person;
	}

	
	public void removePerson(int id) {
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction( ).begin( );
		Person person = entityManager.getReference(Person.class,id);
		entityManager.remove(person);
		entityManager.getTransaction( ).commit( );
	   // entityManager.close( );
		
	}

}
