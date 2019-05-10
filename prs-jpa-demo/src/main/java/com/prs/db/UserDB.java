package com.prs.db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.prs.business.User;

public class UserDB {
	
	public static List<User> getAll() {
		
		List<User> users = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			Query q = em.createQuery("Select u from User u");
			users = q.getResultList();
		} finally {
			em.close();
		}
		
		return users;
	}

}
