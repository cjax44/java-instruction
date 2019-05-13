package com.prs.db;

import java.util.*;
import javax.persistence.*;
import com.prs.business.*;

public class PRDB {

	public static List<PurchaseRequest> getAll() {

		List<PurchaseRequest> pr = null;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			Query q = em.createQuery("Select u from PurchaseRequest u");
			pr = q.getResultList();
		} finally {
			em.close();
		}

		return pr;
	}

	public static void update(PurchaseRequest pr) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(pr);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void delete(PurchaseRequest pr) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {			
			em.remove(em.merge(pr));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static PurchaseRequest selectPurchaseRequest(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u FROM PurchaseRequest u " +
							"WHERE u.id = :id";
		TypedQuery<PurchaseRequest> q = em.createQuery(qString, PurchaseRequest.class);
		q.setParameter("id", id);
		try {
			PurchaseRequest pr = q.getSingleResult();
			return pr;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static void insert(PurchaseRequest pr) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(pr);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
			
		}

}
