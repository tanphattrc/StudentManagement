/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Entity.TongKet;
import Util.HibernateUtil;

/**
 *
 * @author 
 */
public class TongKetDAO {
    public static List<TongKet> layDanhSachTongKet()
    {
        List<TongKet> dsTongKet = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from TongKet";
        Query query = session.createQuery(hql);
        dsTongKet = query.list();
        session.close();
        return dsTongKet;
    }
     public static List<TongKet> layThongTinTongKet(String manamhoc,String malop) {
        List<TongKet> dsTongKet = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from TongKet where manamhoc=:manamhoc and lop=:malop ";
        Query query = session.createQuery(hql);
        query.setParameter("manamhoc", manamhoc);
        query.setParameter("malop", malop);
        dsTongKet = query.list();
        session.close();
        return dsTongKet;
        
    }
    
    // Thêm
    public static String themTongKet(TongKet tongket) {
         
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(tongket);
            session.getTransaction().commit();
            return "true";
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
            return e.getCause().getMessage();
        } finally {
            session.close();
        }
    }
    
    

    
//    
 
    
}
