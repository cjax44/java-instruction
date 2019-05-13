package com.prs.db;

import java.sql.Connection;
import javax.persistence.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.prs.business.*;

public class ProductDB {
	
	public static Product selectProduct(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u FROM Product u " +
							"WHERE u.id = :id";
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
		q.setParameter("id", id);
		try {
			Product prod = q.getSingleResult();
			return prod;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}


	public static List<Product> getAll() {
		String sql = "SELECT ID, VendorID, PartNumber, Name, Price, Unit, PhotoPath " + "FROM Product";
		List<Product> products = null;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			Query q = em.createQuery("Select p from Product p");
			products = q.getResultList();
		} finally {
			em.close();
		} return products;
		
	}

	public static void insert(Product p) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(p);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
			
		}

	public static void update(Product prod) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(prod);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}


	public static void delete(Product prod) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(prod));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

}
