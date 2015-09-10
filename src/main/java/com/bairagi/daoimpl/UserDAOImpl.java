package com.bairagi.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bairagi.common.User;
import com.bairagi.dao.UserDAO;
import com.bairagi.singleton.MyEntityManagerFactory;

@Repository
public class UserDAOImpl extends MyEntityManagerFactory implements UserDAO {
	
	

	public void createUser(User user) {		
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction( ).begin( );
		entityManager.persist(user);
		entityManager.getTransaction( ).commit( );
	   // entityManager.close( );
	   
		
	}

	public User getUser(int id) {
		EntityManager entityManager=getEntityManager();
		User user=entityManager.find(User.class,id);
		//entityManager.close();
		return user;
	}
	
	public List<User> getAllUser(){
		EntityManager entityManager=getEntityManager();
		List<User> userList=entityManager.createQuery("from User").getResultList();
		//entityManager.close();
		return userList;
		
	}

	public User updateUser(int id,User user) {
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction( ).begin( );
		User oldUser=entityManager.find(User.class,id);
		oldUser.setEmail(user.getEmail());
		oldUser.setFirstname(user.getFirstname());
		oldUser.setLastname(user.getLastname());
		oldUser.setPassword(user.getPassword());
		User updatedUser=entityManager.merge(oldUser);
		entityManager.getTransaction( ).commit( );
	   // entityManager.close( );
	    return updatedUser;
		
	}
	
	public void deleteUser(int id){
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction( ).begin( );
		User user = entityManager.getReference(User.class,id);
		entityManager.remove(user);
		entityManager.getTransaction( ).commit( );
	    //entityManager.close( );

		
	}

}
