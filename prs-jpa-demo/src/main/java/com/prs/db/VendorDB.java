package com.prs.db;

import java.util.List;
import javax.persistence.*;

import com.prs.business.*;



public class VendorDB {
	
public static List<Vendor> getAll() {
		
		List<Vendor> vendors = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			Query q = em.createQuery("Select u from Vendor u");
			vendors = q.getResultList();
		} finally {
			em.close();
		}
		
		return vendors;
	}
	
	public static void update(Vendor v) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(v);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void delete(Vendor v) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {			
			em.remove(em.merge(v));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static Vendor selectVendor(int vendorID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u FROM Vendor u " +
							"WHERE u.vendorID = :vendorID";
		TypedQuery<Vendor> q = em.createQuery(qString, Vendor.class);
		q.setParameter("vendorID", vendorID);
		try {
			Vendor v = q.getSingleResult();
			return v;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	
	public static void insert(Vendor v) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(v);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
			
		}
	
}
