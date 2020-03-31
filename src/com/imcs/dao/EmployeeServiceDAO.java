package com.imcs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.imcs.dto.EmployeeDTO;

public class EmployeeServiceDAO {
	private SessionFactory sessionFactory;

	public EmployeeServiceDAO() {
		sessionFactory = new Configuration().configure().addAnnotatedClass(EmployeeDTO.class).buildSessionFactory();

	}

	// Retrieves list of employees
	public List<EmployeeDTO> getAllEmployeeInfo() {
		System.out.println("EmployeeServiceDAO.getAllEmployeeInfo -- BEGIN");

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<EmployeeDTO> employees = null;

		try {
			tx = session.beginTransaction();
			employees = session.createQuery("FROM EmployeeDTO").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}

		System.out.println("EmployeeServiceDAO.getAllEmployeeInfo -- END");
		return employees;
	}

	// Retrieves an employee information based on their employee ID
	public EmployeeDTO getEmployeeInfo(String empId) {
		System.out.println("EmployeeServiceDAO.getEmployeeInfo -- BEGIN");

		EmployeeDTO empDto = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			empDto = session.get(EmployeeDTO.class, empId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}

		System.out.println("EmployeeServiceDAO.getEmployeeInfo -- END");
		return empDto;
	}

	// Adds an employee record or details(employee ID, firstname, lastname, and
	// email) to EMPLOYEES_TEST table
	public boolean addEmployeeInfo(int empID, String empFirstName, String empLastName, String empEmail)
			throws Exception {
		boolean isEmpAdded = false;

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			EmployeeDTO employee = new EmployeeDTO(String.valueOf(empID), empLastName, empFirstName, empEmail);
			session.save(employee);
			isEmpAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}

		return isEmpAdded;
	}

	// update the specific row or record in the employees table
	public boolean updateEmployeeInfo(String pEmpId, String pFirstName, String pLastName,
			String pEmail) throws Exception {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean isEmpUpdated = false;

		try {
			tx = session.beginTransaction();
			EmployeeDTO employee = session.get(EmployeeDTO.class, pEmpId);
			employee.setFirstName(pFirstName);
			employee.setLastName(pLastName);
			employee.setEmailId(pEmail);
			session.update(employee);
			isEmpUpdated = true;
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return isEmpUpdated;
	}

	// Removes an existing record in the table
	public boolean removeEmployeeInfo(String pEmpId) throws Exception {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean isEmpDeleted = false;
//		int employeeId = Integer.parseInt(pEmpId);

		try {
			tx = session.beginTransaction();
			EmployeeDTO employee = session.get(EmployeeDTO.class, pEmpId);
			session.delete(employee);
			isEmpDeleted = true;
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}

		return isEmpDeleted;

	}
}
