package com.wallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	private static final String EMAIL = "ricardobatistarg@gmail.com";
	
	@Autowired
	UserRepository repository;
	
	@Before
	public void setup() {
		
		User u = new User();
		u.setName("Ricardo");
		u.setPassword("123");
		u.setEmail(EMAIL);
		
		repository.save(u);
		
	}
	
	@After
	public void tearDown() {
		
		repository.deleteAll();
		
	}

	@Test
	public void testSave() {
		User u = new User();
		u.setName("Ricardo");
		u.setPassword("123");
		u.setEmail("ricardobatistarg@gmail.com");
		
		User response = repository.save(u);
		
		assertNotNull(response);
	}
	
	@Test
	public void testByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
	
}
