/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entity.Khoi;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Carvin
 */
public class KhoiDAO {
    public static List<Khoi> layDanhSachKhoi()
    {
        List<Khoi> dsKhoi = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from Khoi";
        Query query = session.createQuery(hql);
        dsKhoi = query.list();
        session.close();
        return dsKhoi;
    }
     public static List<Khoi> layThongTinKhoi(int maKhoi) {
        List<Khoi> dsKhoi = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from Khoi where id=:makhoi ";
        Query query = session.createQuery(hql);
        query.setParameter("makhoi", maKhoi);
        dsKhoi = query.list();
        session.close();
        return dsKhoi;
        
    }
     
     public static int LaySiSoHSToiDa(int maKhoi) {
        List<Khoi> dsKhoi = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from Khoi where id=:makhoi ";
        Query query = session.createQuery(hql);
        query.setParameter("makhoi", maKhoi);
        dsKhoi = query.list();
        session.close();
        if(dsKhoi.size() > 0)
        {
            return dsKhoi.get(0).getsisotoida();
        }
        
        return -1;
        
    }
       
    
     // sửa
    public static boolean capNhatKhoi(Khoi khoi) {
        List<Khoi> mh = KhoiDAO.layThongTinKhoi(khoi.getid());
       if(mh.size() < 1)
           return false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(khoi);
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
