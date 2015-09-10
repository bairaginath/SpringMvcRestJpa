package com.bairagi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Qualifier;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bairagi.common.User;
import com.bairagi.pojo.MyResponse;
import com.bairagi.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserCURDRestController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml" })
	public ResponseEntity getUser(@PathVariable int id) {
		   User user=null;
            
			 user=userService.getUser(id);
            if(user==null){
            	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MyResponse("user doesn't exit","USER_NOT_FOUND",null,null));
            }
            return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json", "application/xml" })
	public List<User> getAllUser() {		
		return userService.getAllUser();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml" })
	public ResponseEntity deleteUser(@PathVariable int id) {
           String message="Delete Successfully";
           try{
        	  userService.deleteUser(id); 
           }catch(Exception e){ 
        	   message="Delete Failure";
        	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MyResponse(message,"INTERNAL_SERVER_ERROR",null,null));
           
           }
           return ResponseEntity.status(HttpStatus.OK).body(new MyResponse(message,null,null,null));
	   
		    
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = {"application/json", "application/xml" },consumes={"application/json", "application/xml" })
	public User createUser(@RequestBody User user) throws Exception {
		userService.createUser(user);
		return user;

    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json", "application/xml" },consumes={"application/json", "application/xml" })
	public User updateUser(@PathVariable int id,@RequestBody User user) throws Exception {
		userService.updateUser(id,user);
		return userService.updateUser(id,user);

    }
}
