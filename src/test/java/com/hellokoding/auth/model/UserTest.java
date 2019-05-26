package com.hellokoding.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserTest {
	
	static User u;
	
	@BeforeAll
	public static void initialize() {
		u = new User();
	}

	@Test
	public void testId() {
		u.setId(1L);
		assertEquals(1L, u.getId());
	}
	
	@Test
	public void testUsername() {
		u.setUsername("Laura");
		assertEquals("Laura", u.getUsername());
	}
	
	@Test
	public void testPassword() {
		u.setPassword("password");
		assertEquals("password", u.getPassword());
	}
	
	@Test
	public void testPasswordConfirm() {
		u.setPasswordConfirm("password");
		assertEquals("password", u.getPasswordConfirm());
	}
	
	@Test
	public void testRoles() {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role());
		u.setRoles(roles);
		assertEquals(roles, u.getRoles());
	}
}
