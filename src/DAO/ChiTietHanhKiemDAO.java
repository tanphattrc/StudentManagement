package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Entity.ChiTietHanhKiem;
import Entity.Diem;
import Entity.Mon;
import Entity.ChiTietHanhKiem;
import Util.HibernateUtil;

public class ChiTietHanhKiemDAO {

	  public static List<ChiTietHanhKiem> layDanhSachChiTietHanhKiem(String mahocsinh,String malop, String mahocky)
	    {
	        List<ChiTietHanhKiem> dsChiTietHanhKiem = null;
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        String hql = "from ChiTietHanhKiem where mahocsinh=:mahocsinh and mahocky=:mahocky and malop=:malop";
	        Query query = session.createQuery(hql);
	        query.setParameter("mahocsinh", mahocsinh);
	        query.setParameter("mahocky", mahocky);
	        query.setParameter("malop", malop);
	        dsChiTietHanhKiem = query.list();
	        session.close();
	        return dsChiTietHanhKiem;
	    }
	  
		public static String themChiTietHanhKiem(ChiTietHanhKiem cthk) {
			List<ChiTietHanhKiem> hanhkiems= laythongtinCTHK(cthk.getMahocsinh(), cthk.getMahocky());
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				session.beginTransaction();
				if (hanhkiems.size()>0)
				{
				cthk.setId(hanhkiems.get(0).getId());
				session.update(cthk);
				}
				else
				{
					session.save(cthk);
				}
			
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
		  public static List<ChiTietHanhKiem> laythongtinCTHK(String mahocsinh,String mahocky) {
		        List<ChiTietHanhKiem> dsChiTietHanhKiem = null;
		        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        session.beginTransaction();
		        String hql = "from ChiTietHanhKiem where mahocsinh=:mahocsinh and mahocky=:mahocky ";
		        Query query = session.createQuery(hql);
		        query.setParameter("mahocsinh", mahocsinh);
		        query.setParameter("mahocky", mahocky);
		        dsChiTietHanhKiem = query.list();
		        session.close();
		        return dsChiTietHanhKiem;
		        
		    }
}
