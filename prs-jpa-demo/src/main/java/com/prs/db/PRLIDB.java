package com.prs.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.prs.business.PurchaseRequest;
import com.prs.business.PurchaseRequestLineItem;

public class PRLIDB {
	
	public static List<PurchaseRequestLineItem> getAll() {

		List<PurchaseRequestLineItem> pr = null;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			Query q = em.createQuery("Select u from PurchaseRequest u");
			pr = q.getResultList();
		} finally {
			em.close();
		}

		return pr;
	}

	public static void update(PurchaseRequestLineItem pr) {
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
	
	public static void delete(PurchaseRequestLineItem pr) {
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
	
	public static PurchaseRequestLineItem selectPurchaseRequestLineItem(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u FROM PurchaseRequestLineItem u " +
							"WHERE u.id = :id";
		TypedQuery<PurchaseRequestLineItem> q = em.createQuery(qString, PurchaseRequestLineItem.class);
		q.setParameter("id", id);
		try {
			PurchaseRequestLineItem pr = q.getSingleResult();
			return pr;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static void insert(PurchaseRequestLineItem pr) {
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
