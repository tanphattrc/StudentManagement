/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Diem;
import Entity.HocSinh;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Carvin
 */
public class HocSinhDAO {
    
    /// lấy danh sách học sinh
    public static List<HocSinh> layDanhSachHocSinh()
    {
        List<HocSinh> dsHocSinh = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from HocSinh ORDER BY lop,mahocsinh ";
        Query query = session.createQuery(hql);
        dsHocSinh = query.list();
        session.close();
        return dsHocSinh;
    }
    
    /// tìm học  sinh được chọn
    public static List<HocSinh> layThongTinHocSinh(String maHocSinh) {
//         Session session = HibernateUtil.getSessionFactory().openSession();
//         session.beginTransaction();
//         HocSinh hs = (HocSinh) session.get(HocSinh.class, maHocSinh);
//         session.close();
//         return hs;
        // c2
        List<HocSinh> dsHocSinh = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from HocSinh where mahocsinh=:mahs ";
        Query query = session.createQuery(hql);
        query.setParameter("mahs", maHocSinh);
        dsHocSinh = query.list();
        session.close();
        return dsHocSinh;
        
    }
    
    public static List<HocSinh> LopCoBaoNhieuHocSinh(String malop) {
        List<HocSinh> dsHocSinh = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from HocSinh where lop=:malop ";
        Query query = session.createQuery(hql);
        query.setParameter("malop", malop);
        dsHocSinh = query.list();
        session.close();
        return dsHocSinh;
        
    }
    
     public static List<HocSinh> Timhocsinhcualop(String tenlop) {
        List<HocSinh> dsHocSinh = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "select hs from HocSinh  as  hs ,Lop  as  lp where hs.lop = lp.malop and( lp.tenlop like:tenlop or lp.malop like:tenlop  )";
        Query query = session.createQuery(hql);
        query.setParameter("tenlop", "%"+tenlop+"%"); 
        dsHocSinh = query.list();
        session.close();
        return dsHocSinh;
        
    }
    
    // Thêm
    public static boolean themHocSinh(HocSinh hs) {
        List<HocSinh> d =HocSinhDAO.layThongTinHocSinh(hs.getmahocsinh());
        if(d.size() == 1)
           return false;   
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(hs);
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
    
    
     // sửa
    public static boolean capNhatHocSinh(HocSinh hs) {
        List<HocSinh> mh = HocSinhDAO.layThongTinHocSinh(hs.getmahocsinh());
       if(mh.size() < 1)
           return false;
        hs.setid(mh.get(0).getid());
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(hs);
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
    
    public static boolean xoaHocSinh(String mahs) {
       List<HocSinh> mh = HocSinhDAO.layThongTinHocSinh(mahs);
       if(mh == null)
           return false;
//        aa
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "delete from Diem where mahocsinh=:mahocsinh";
            Query query = session.createQuery(hql);
            query.setParameter("mahocsinh", mh.get(0).getmahocsinh()); 
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
