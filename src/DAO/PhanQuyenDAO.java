/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.PhanQuyen;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Carvin
 */
public class PhanQuyenDAO {
     public static List<PhanQuyen> layDanhSachPhanQuyen()
    {
        List<PhanQuyen> dsPhanQuyen = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from PhanQuyen";
        Query query = session.createQuery(hql);
        dsPhanQuyen = query.list();
        session.close();
        return dsPhanQuyen;
    }
}
