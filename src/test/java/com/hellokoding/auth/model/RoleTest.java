package com.hellokoding.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class RoleTest {

	@Test
	void testGetUsers() {
		Role r = new Role();
		User u1 = new User ();
		User u2 = new User ();
		Set <User> users = new HashSet <User>();
		users.add(u1);
		users.add(u2);
		r.setUsers(users);
		assertTrue(r.getUsers().equals(users));
	}

	@Test
	void testSetUsers() {
		Role r = new Role();
		Set <User> users = new HashSet <User>();
		User s = new User();
		users.add(s);
		r.setUsers(users);
		assertTrue(r.getUsers().equals(users));
	}
	
	@Test
	void testgetSetName() {
		String name;
		Role r = new Role();
		r.setName("Administrador");
		name = r.getName();
		assertTrue(name.equals("Administrador"));
		
	}
	
	@Test
	void testgetSetId(){
		long id;
		Role r =  new Role();
		r.setId(12345L);
		id = r.getId();
		assertTrue(id == 12345L);
	}

}
