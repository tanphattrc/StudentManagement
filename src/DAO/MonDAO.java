/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Mon;
import GUI.MonHoc;
import Util.HibernateUtil;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Carvin
 */
public class MonDAO {
    public static List<Mon> layDanhSachMon()
    {
        List<Mon> dsMon = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from Mon";
        Query query = session.createQuery(hql);
        dsMon = query.list();
        session.close();
        return dsMon;
    }
     public static List<Mon> layThongTinMon(String maMon) {
        List<Mon> dsMon = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from Mon where mamon=:mamon ";
        Query query = session.createQuery(hql);
        query.setParameter("mamon", maMon);
        dsMon = query.list();
        session.close();
        return dsMon;
        
    }
    
    // Thêm
    public static String themMon(Mon mon) {
         List<Mon> m = MonDAO.layThongTinMon(mon.getmamon());
        if(m.size() > 0)
           return "Mã môn đã tồn tại"; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(mon);
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
    
    
     // sửa
    public static String capNhatMon(Mon mon) {
        List<Mon> mh = MonDAO.layThongTinMon(mon.getmamon());
       if(mh.size() < 1)
           return "false";
        mon.setid(mh.get(0).getid());
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(mon);
            session.getTransaction().commit();
            return "true";
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getCause().getMessage());
           
            return e.getCause().getMessage();
        } finally {
            session.close();
        }
    }
    
//    
    public static boolean xoaMon(String mamon) {
       List<Mon> mh = MonDAO.layThongTinMon(mamon);
       if(mh == null)
           return false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "delete from Diem where mamonhoc=:mamonhoc";
            Query query = session.createQuery(hql);
            query.setParameter("mamonhoc", mh.get(0).getmamon()); 
            query.executeUpdate();
            session.delete(mh.get(0));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        } finally {
            session.close();
        }
    }
    
}
