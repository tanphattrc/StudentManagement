/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HanhKiem;
import Util.HibernateUtil;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Carvin
 */
public class HanhKiemDAO {
	 private static SessionFactory factory;
    public static List<HanhKiem> findAll()
    {
        List<HanhKiem> dsHanhKiem = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from HanhKiem";
            Query query = session.createQuery(hql);
            dsHanhKiem = query.list();	
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
     
        return dsHanhKiem;
    }
    public static List<HanhKiem> findByID(int mahanhkiem)
    {
        List<HanhKiem> dsHanhKiem = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from HanhKiem where id=:mahanhkiem";
            Query query = session.createQuery(hql);
            query.setParameter("mahanhkiem", mahanhkiem);
            dsHanhKiem = query.list();	
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
     
        return dsHanhKiem;
    }
}
