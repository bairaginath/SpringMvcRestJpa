package com.bairagi.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyEntityManagerFactory {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	private EntityManager entityManager;
	

	
	protected EntityManager getEntityManager(){
	 // return entityManagerFactory.createEntityManager();
		if(entityManager==null){
			System.out.println("Inside entityManger Creation=============================================================================================");
			entityManager=entityManagerFactory.createEntityManager();			
		}
		return entityManager;
		
		
	}

}
