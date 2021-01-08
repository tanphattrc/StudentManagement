/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entity.TaiKhoan;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import Util.HibernateUtil;
import Util.MD5Lib;
/**
 *
 * @author Carvin
 */
public class TaiKhoanDAO {
    public static List<TaiKhoan> layDanhSachTaiKhoan()
    {
        List<TaiKhoan> dsTaiKhoan = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from TaiKhoan";
        Query query = session.createQuery(hql);
        dsTaiKhoan = query.list();
        session.close();
        return dsTaiKhoan;
    }
    
    // đăng nhập
    public static int DangNhap ( String tk, String mk ) {
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "";
        int loai = 0;
        hql = "from TaiKhoan where tentaikhoan=:ma and matkhau=:matkhau";
//        hql = "select count(*)from TaiKhoan where tentaikhoan=:ma and matkhau=:matkhau";
        Query query = session.createQuery(hql);
        query.setParameter("ma", tk);
        query.setParameter("matkhau", MD5Lib.md5(mk));
//        query.setParameter("matkhau", mk);
//        Long count = (Long)query.uniqueResult();
        List<TaiKhoan> dstk = null;
        dstk = query.list();
        session.close();
        
        if( dstk.size() > 0 ) {       
            loai = dstk.get(0).getchucvu();
            return loai;
        } else {
            return loai;
        }
    }
     
     /// tìm tai khoản được chọn
    public static List<TaiKhoan> layThongTinTaiKhoan(String maTaiKhoan) {

        List<TaiKhoan> dsTaiKhoan = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from TaiKhoan where tentaikhoan=:matk ";
        Query query = session.createQuery(hql);
        query.setParameter("matk", maTaiKhoan);
        dsTaiKhoan = query.list();
        session.close();
        return dsTaiKhoan;
        
    }

    // Thêm
    public static String themTaiKhoan(TaiKhoan tk) {
        List<TaiKhoan> d = TaiKhoanDAO.layThongTinTaiKhoan(tk.gettentaikhoan());
        if(d.size() > 0)
           return "existed";  
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(tk);
            session.getTransaction().commit();
            return "true";
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
            return "false";
        } finally {
            session.close();
        }
    }
    
    // sửa
    public static boolean capNhatTaiKhoan(TaiKhoan tk) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(tk);
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
    
    public static boolean xoaTaiKhoan(String matk) {
       List<TaiKhoan> mh = TaiKhoanDAO.layThongTinTaiKhoan(matk);
       if(mh == null)
           return false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
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
