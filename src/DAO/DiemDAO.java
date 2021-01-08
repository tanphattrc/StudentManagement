/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Diem;
import Util.HibernateUtil;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Carvin
 */
@Transactional
public class DiemDAO {
	private static SessionFactory factory;
	
	public static String BaoCaoCuoiNam(String mahocsinh,String mahocky1,String mahocky2,int mahanhkiem,Float tbm)
	{
		boolean hsg=true,hstt=true,hstb=true,hsy=true;
		float toan1= DiemCuaHocSinh(mahocsinh, mahocky1, "toan").get(0).getDiemtbmon();
		float toan2= DiemCuaHocSinh(mahocsinh, mahocky2, "toan").get(0).getDiemtbmon();
		float van1= DiemCuaHocSinh(mahocsinh, mahocky1, "van").get(0).getDiemtbmon();
		float van2= DiemCuaHocSinh(mahocsinh, mahocky2, "van").get(0).getDiemtbmon();
		
		float toan=  (toan2*2 + toan1)/3;
		float van = (van2*2 + van1)/3; 
		
		if (toan>=6.5 && van >=8 &&hsg==true|| toan>=8 && van >=6.5 && hsg==true)
		{
			hsg=true;
		}
		else
			if (toan>=6.5 && van >=5 &&hstt==true|| toan>=5 && van >=6.5 && hstt==true)
			{
				hsg=false;
				hstt=true;
			}
			else
				if (toan>=5 && van >=5 &&hstb==true)
				{
					hstt=false;
					hstb=true;
				}
			
					
				
		if (tbm>=8 && hsg==true && mahanhkiem==1)
		{
			return "GIỎI";
		}
		else
		if (tbm>6.5 && hstt==true && mahanhkiem==1 || tbm>6.5 && hstt==true && mahanhkiem==2)
		{
			return "KHÁ";
		}
		else
			if (tbm>=5 && hstb==true && mahanhkiem<=3)
			{
				return "TRUNG BÌNH";
			}
			else
				if (tbm>=3.5 && hsy==true)
				{
					return "YẾU";
				}
				else
					return "KÉM";
		
	}
	public static String BaoCaoHocKy(String mahocsinh,String mahocky,int mahanhkiem)
	{
		List<Diem> dsDiem = DiemCuaHocSinh(mahocsinh, mahocky);
		float tbm=0;
		float toan=0,van=0;
		boolean hsg=true,hstt=true,hstb=true,hsy=true;
		for(Diem d : dsDiem)
		{
			if (d.getMamonhoc().equals("toan"))
			{
				toan=d.getDiemtbmon();
			}
			if (d.getMamonhoc().equals("van"))
			{
				van=d.getDiemtbmon();
			}
			if (d.getDiemtbmon()<6.5)
			{
				hsg=false;
				
			}
			
			if (d.getDiemtbmon()<5)
			{
				hstt=false;
				
			}
			
			if (d.getDiemtbmon()<3.5)
			{
				hstb=false;
				
			}
			if (d.getDiemtbmon()<2)
			{
				hsy=false;
			}
			tbm += d.getDiemtbmon();
		}
		if (toan>=6.5 && van >=8 &&hsg==true|| toan>=8 && van >=6.5 && hsg==true)
		{
			hsg=true;
		}
		else
			if (toan>=6.5 && van >=5 &&hstt==true|| toan>=5 && van >=6.5 && hstt==true)
			{
				hsg=false;
				hstt=true;
			}
			else
				if (toan>=5 && van >=5 &&hstb==true)
				{
					hstt=false;
					hstb=true;
				}
			
					
				
		tbm=tbm/dsDiem.size();
		if (tbm>=8 && hsg==true && mahanhkiem==1)
		{
			return "GIỎI";
		}
		else
		if (tbm>6.5 && hstt==true && mahanhkiem==1 || tbm>6.5 && hstt==true && mahanhkiem==2)
		{
			return "KHÁ";
		}
		else
			if (tbm>=5 && hstb==true && mahanhkiem<=3)
			{
				return "TRUNG BÌNH";
			}
			else
				if (tbm>=3.5 && hsy==true)
				{
					return "YẾU";
				}
				else
					return "KÉM";
		

	}
	public static List<Diem> layDanhSachDiem() {
		List<Diem> dsDiem = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from Diem  ORDER BY malop,mahocsinh,mamonhoc,mahocky";
		try {
			Query query = session.createQuery(hql);
			dsDiem = query.list();
		} finally {
			session.close();

		}

		return dsDiem;
	}

	/// tìm học sinh được chọn
	public static List<Diem> DiemCuaHocSinh(String mahocsinh, String maHocKy) {
		List<Diem> dsDiem = null;
		factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = " from Diem where mahocsinh=:mahs and mahocky=:mahk";
			Query query = session.createQuery(hql);
			query.setParameter("mahs", mahocsinh);
			query.setParameter("mahk", maHocKy);
			dsDiem = query.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dsDiem;

	}
	
	public static List<Diem> findBy3Ma(String mahocsinh,String malop, String maHocKy) {
		List<Diem> dsDiem = null;
		factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = " from Diem where mahocsinh=:mahs and malop=:malop and mahocky=:mahk";
			Query query = session.createQuery(hql);
			query.setParameter("mahs", mahocsinh);
			query.setParameter("mahk", maHocKy);
			query.setParameter("malop", malop);
			dsDiem = query.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dsDiem;

	}

	/// tìm học sinh được chọn
	public static List<Diem> DiemCuaHocSinh(String mahocsinh, String maHocKy, String maMon) {
		List<Diem> dsDiem = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from Diem where mahocsinh=:mahs and mahocky=:mahk and mamonhoc =:mamon";
		Query query = session.createQuery(hql);
		query.setParameter("mahs", mahocsinh);
		query.setParameter("mahk", maHocKy);
		query.setParameter("mamon", maMon);
		dsDiem = query.list();
		session.close();
		return dsDiem;

	}

	/// tìm học sinh được chọn
	public static List<Diem> layThongTinDiemCuaHocSinh(String malop, String mahocsinh, String maMon, String maHocKy) {
		List<Diem> dsDiem = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			String hql = "from Diem where mahocsinh=:mahs and mamonhoc=:mamon and mahocky=:mahk and malop=:malop ";
			Query query = session.createQuery(hql);
			query.setParameter("mahs", mahocsinh);
			query.setParameter("mamon", maMon);
			query.setParameter("mahk", maHocKy);
			query.setParameter("malop", malop);
			dsDiem = query.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dsDiem;

	}

	/// tìm theo ma hoc sinh
	public static List<Diem> TimKiem(String malop, String mahocsinh, String maMon, String maHocKy) {
		List<Diem> dsDiem = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			String hql="from Diem ";
		
				 hql += "where mahocsinh like:mahs "; 
		
			
			if (malop != null) {
				hql += "and malop=:malop ";
				
			} 
			if (maMon != null) {
				hql += "and mamonhoc=:mamon ";
				
			} 
			if (maHocKy != null) {
				 hql += " and mahocky=:mahk"; 
				
			}
			tx = session.beginTransaction();
			Query query= session.createQuery(hql);
			if (mahocsinh!=null)
			{
				query.setParameter("mahs", "%" + mahocsinh + "%");
			}
			else
			{
				query.setParameter("mahs", "%" + 0 + "%");
			}
		
			
			if (malop != null) {
				query.setParameter("malop", malop);
			} 
			if (maMon != null) {
				query.setParameter("mamon", maMon);
			} 
			if (maHocKy != null) {
				query.setParameter("mahk", maHocKy);
			}
		
			dsDiem = query.list();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dsDiem;

	}

	// Thêm
	public static String themDiem(Diem diem) {
		List<Diem> d = DiemDAO.layThongTinDiemCuaHocSinh(diem.getMalop(), diem.getMahocsinh(), diem.getMamonhoc(),
				diem.getMahocky());
		if (d.size() == 1)
			return "existed";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(diem);
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
	public static boolean capNhatDiem(Diem diem) {
		List<Diem> d = DiemDAO.layThongTinDiemCuaHocSinh(diem.getMalop(), diem.getMahocsinh(), diem.getMamonhoc(),
				diem.getMahocky());
		if (d.size() < 1)
			return false;
		diem.setId(d.get(0).getId());
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(diem);
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

	public static boolean xoaDiem(Diem diem) {
		List<Diem> d = DiemDAO.layThongTinDiemCuaHocSinh(diem.getMalop(), diem.getMahocsinh(), diem.getMamonhoc(),
				diem.getMahocky());
		if (d.size() < 1)
			return false;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(d.get(0));
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
