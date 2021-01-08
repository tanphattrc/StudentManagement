/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.GiaoVu;
import Util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Carvin
 */
public class GiaoVuDAO {
     public static List<GiaoVu> layDanhSachGiaoVu()
    {
        List<GiaoVu> dsGiaoVu = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from GiaoVu";
        Query query = session.createQuery(hql);
        dsGiaoVu = query.list();
        session.close();
        return dsGiaoVu;
    }
     public static List<GiaoVu> layThongTinGiaoVu(int maGiaoVu) {
        List<GiaoVu> dsGiaoVu = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from GiaoVu where id=:id ";
        Query query = session.createQuery(hql);
        query.setParameter("id", maGiaoVu);
        dsGiaoVu = query.list();
        session.close();
        return dsGiaoVu;
        
    }
     
    //lay so tuoi quy dinh
     public static String laySoTuoiToiThieu()
    {
        String tuoi = "";
        List<GiaoVu> dsGiaoVu = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from GiaoVu";
        Query query = session.createQuery(hql);
        dsGiaoVu = query.list();
        session.close();
        int t = 1999;
        if (dsGiaoVu.size() > 0){
            t = dsGiaoVu.get(0).gettuoitoithieu();
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
            String nam = simpleDateFormat.format(date).toUpperCase();           
            t = Integer.parseInt(nam) - t;
        }
                 
        tuoi  = String.valueOf(t);
        return tuoi;
    }
     
      //lay so tuoi quy dinh
     public static String laySoTuoiToiDa()
    {
        String tuoi = "";
        List<GiaoVu> dsGiaoVu = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from GiaoVu";
        Query query = session.createQuery(hql);
        dsGiaoVu = query.list();
        session.close();
        int t = 1999;
        if (dsGiaoVu.size() > 0){
            t = dsGiaoVu.get(0).gettuoitoida();
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
            String nam = simpleDateFormat.format(date).toUpperCase();           
            t = Integer.parseInt(nam) - t;
        }
                 
        tuoi  = String.valueOf(t);
        return tuoi;
    }
        
     // sửa
    public static boolean capNhatGiaoVu(GiaoVu giaovu) {
       
        giaovu.setid(1);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(giaovu);
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
