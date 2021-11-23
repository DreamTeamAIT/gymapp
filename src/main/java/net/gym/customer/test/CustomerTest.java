package net.gym.customer.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.gym.customer.model.Customer;

class CustomerTest {
	Customer customer;
	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer("1","Peter", "Curry", "password", "email@email.com");
	}

	

	@Test
	void testGetFirstName() {
		assertEquals(customer.getFirstName(), "Peter");
	}

	@Test
	void testSetFirstName() {
		customer.setFirstName("John");
		assertEquals(customer.getFirstName(),"John");
		}

	@Test
	void testGetLastName() {
		assertEquals(customer.getLastName(), "Curry");
	}

	@Test
	void testSetLastName() {
		customer.setLastName("Smith");
		assertEquals(customer.getLastName(),"Smith");
		}

	@Test
	void testGetPassword() {
		assertEquals(customer.getPassword(), "password");
	}

	@Test
	void testSetPassword() {
		customer.setPassword("newPassword");
		assertEquals(customer.getPassword(), "newPassword");
	}

	@Test
	void testGetEmail() {
		assertEquals(customer.getEmail(),"email@email.com");
	}

	@Test
	void testSetEmail() {
		customer.setEmail("newemail@email.com");
		assertEquals(customer.getEmail(), "newemail@email.com");
	}

	@Test
	void testGetId() {
		assertEquals(customer.getId(),"1");
	}

	@Test
	void testSetId() {
		customer.setId("2");
		assertEquals(customer.getId(), "2");
	}

}
