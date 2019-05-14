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
		fail("Not yet implemented");
	}

}
