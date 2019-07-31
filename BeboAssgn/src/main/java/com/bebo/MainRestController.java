package com.bebo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bebo.entity.User;

@RestController
@RequestMapping(value = "/rest")
public class MainRestController {

	
	@Autowired
	DataSource dataSource;
	
	@PersistenceContext
	EntityManager em;
	
	@RequestMapping(value = "/a/{a}")
	@Transactional(propagation = Propagation.REQUIRED)
	public void test(@PathVariable int a) {
		System.out.println("%%%%%%%%%%%%%%%%%%%%");
		System.out.println(dataSource);
		System.out.println(em);
		
		User user = new User();
		user.setIdUsers(a);
		user.setEmail("test@email.com");
		user.setMobileNum(324323);
		user.setPassword("abc");
		//Session session = em.unwrap(Session.class);
		//em.getTransaction().begin();
		em.persist(user);
		//em.getTransaction().commit();
	}
	
	
}
