package net.gym.customer.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.discovery.predicates.IsTestClassWithTests;

import com.mysql.cj.xdevapi.Result;

import net.gym.customer.dao.CustomerDao;
import net.gym.customer.model.Customer;

class CustomerDaoTest {

	CustomerDao testCustomerDao = new CustomerDao();
	@BeforeEach
	void setUp() throws Exception {
		testCustomerDao.ResetCustomerDatabase();	}

	@Test
	void testResetDatabase() throws ClassNotFoundException {
		// Our reset database is mostly used for testing. It sets the database to a default state.
		//We want to reset it, then confirm the two default entires are in the database
		testCustomerDao.ResetCustomerDatabase();
		boolean result = testCustomerDao.deleteChecker(new Customer("1", "Peter", "Curry", "12345", "email@email.com"));
		assertEquals(result, true);
		result = testCustomerDao.deleteChecker(new Customer("2", "Paul", "Rice", "678910", "paulrocks@email.com"));
		assertEquals(result, true);
			}

	@Test
	void testRegisterCustomer() throws ClassNotFoundException {
		//Register a customer, and confirm it's in the database
		Customer customer = new Customer("3", "John", "Joe", "Potatoes", "JJ@email.com");
		testCustomerDao.registerCustomer(customer);
		boolean result = testCustomerDao.deleteChecker(customer);
		assertEquals(result, true);
	}

	@Test
	void testDeleteCustomer() throws ClassNotFoundException {
		//Delete a customer, and confirm they're no longer in the database
		Customer customer = new Customer("1", "Peter", "Curry", "12345", "email@email.com");
		testCustomerDao.deleteCustomer("1");	
		boolean result = testCustomerDao.deleteChecker(customer);
		assertEquals(result, false);
	}

	@Test
	void testDeleteChecker() throws ClassNotFoundException {
		//Confirm whether the function correctly determines an entry is there. Since we set up the database, the entry should be there.
		Customer customer = new Customer("1", "Peter", "Curry", "12345", "email@email.com");
		boolean result = testCustomerDao.deleteChecker(customer);
		assertEquals(result, true);
	}

	@Test
	void testUpdateCustomer() throws ClassNotFoundException {
		Customer customer = new Customer("1", "Joey", "Curry", "Beep", "newemail@email.com");
		testCustomerDao.updateCustomer(customer);
		boolean result = testCustomerDao.deleteChecker(customer);
		assertEquals(result, true);
		
	}
/*
	@Test
	void testSelectAllCustomer() throws ClassNotFoundException {
		List <Customer> list = testCustomerDao.selectAllCustomer();
		List <Customer> dataList = new ArrayList <Customer>();
		Customer customer1 = new Customer("1", "Peter", "Curry", "12345", "email@email.com");
		Customer customer2 = new Customer("2", "Paul", "Rice", "678910", "paulrocks@email.com");
		dataList.add(customer1);
		dataList.add(customer2);
		
		assertEquals(list.get(0).toString(), dataList.get(0).toString());
		assertEquals(list.get(1).toString(), dataList.get(1).toString());

	}
*/
}
