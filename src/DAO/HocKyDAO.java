/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HocKy;
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
public class HocKyDAO {
	 private static SessionFactory factory;
    public static List<HocKy> layDanhSachHocKy()
    {
        List<HocKy> dsHocKy = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from HocKy";
            Query query = session.createQuery(hql);
            dsHocKy = query.list();	
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
     
        return dsHocKy;
    }
}
