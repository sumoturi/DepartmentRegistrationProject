package com.java.demo.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.demo.bo.DepartmentDO;

public class DepartmentDAO {

	private SessionFactory xeConSessionFactory = null;

	public void setXeConSessionFactory(SessionFactory xeConSessionFactory) {
		this.xeConSessionFactory = xeConSessionFactory;
	}

	public DepartmentDO getDepartmentByPK(Integer deptPk) {
		DepartmentDO deptDoObj = null;
		Session xeConSession = xeConSessionFactory.openSession();
		Transaction tx = null;
	      try {
		 tx = xeConSession.beginTransaction();
		 deptDoObj = (DepartmentDO) xeConSession.get(DepartmentDO.class, deptPk);
		 tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  xeConSession.close(); 
	      }
		return deptDoObj;
		}
	
	 /* Method to CREATE a department in the database */
	   public Integer addDepartment(String deptName, int mgrId, int locId){
		  Session xeConSession = xeConSessionFactory.openSession();
		  Transaction tx = null;
	      Integer deptID = null;
	      try {
	 		 tx = xeConSession.beginTransaction();
	         DepartmentDO department = new DepartmentDO(deptName, mgrId, locId);
	         deptID = (Integer) xeConSession.save(department);
	         tx.commit();
	      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		    	  xeConSession.close(); 
		      }
	      return deptID;
	   }
	   
	   /* Method to UPDATE department name for a department */
	   public boolean updateDepartment(Integer deptId, String deptName ){
		   Transaction tx = null;
		   boolean updated = false;
		  Session xeConSession = xeConSessionFactory.openSession();
		  try {
		 	tx = xeConSession.beginTransaction();
	         DepartmentDO dept = (DepartmentDO) xeConSession.get(DepartmentDO.class, deptId); 
	         dept.setDeptName(deptName);
	         xeConSession.update(dept);
	         tx.commit();
	         updated = true;
	         xeConSession.close();
		  } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		    	  xeConSession.close(); 
		      }
	   return updated;
}
}
