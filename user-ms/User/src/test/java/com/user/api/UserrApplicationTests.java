package com.user.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.user.api.controller.UserController;
import com.user.api.model.User;
import com.user.api.repository.UserRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserrApplicationTests {
	
	@Autowired
	private UserController userController;
	
	@MockBean              //mocks the repository so the changes here are not reflected
	private UserRepository userRepository;

	@Test
	@Order(1)        //gives sequence to junit, in which the test cases should be run
	public void postUserTest() {
		User user = new User(22L, "Danile", "male", "8975179177", "daniel@gmail.com", "sdf", "user");   //creates new passenger
		when(userRepository.save(user)).thenReturn(user);                         //when passenger is saved return the same
		assertEquals(user, userController.postUser(user));        //checks if expected value and actual value are equal
	}
	
	@Test
	@Order(2)
	public void getAllUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream  //when findAll() method is called then return the list of passengers, it mocks the return values 
				.of(new User(22L, "Danile", "male", "8975179177", "daniel@gmail.com", "sdf", "user"), 
					new User(33L, "Huy", "male", "9922556160", "huy@gmail.com", "wer","admin"))
				.collect(Collectors.toList()));
		assertEquals(2, userController.getAllUsers().size());   //checks if expected value 2 is equal to the value of size i.e expected value
	}
    
	@Test
	@Disabled
	public void updateUserTest() {
		User u = userRepository.findById(1L).get();
		u.setEmail("anushkagawade@gmail.com");
		userRepository.save(u);
		assertNotEquals("anushka@gmail.com", userRepository.findById(1L).get().getEmail());
	}

	/*
	@Test
	@Order(3)
	public void updatePassTest() {
		Passenger passenger = new Passenger(22L, "Danile", "daniel@gmail.com", "9922556160", "sdf", "sdf");   //creates new passenger
		when(passengerRepository.save(passenger)).thenReturn(passenger);                         //when passenger is saved return the same
		assertEquals(passenger, passengerController.updatePass(passenger));        //checks if expected value and actual value are equal
	}
	*/
	
	@Test
	@Order(3)
	public void deleteUserTest() {
		Long id = 22L;
		userController.deleteUser(id);                     //deletes passenger by id
		verify(userRepository, times(1)).deleteById(id);       //verifies if the deleteById method is called once
	}
	
}