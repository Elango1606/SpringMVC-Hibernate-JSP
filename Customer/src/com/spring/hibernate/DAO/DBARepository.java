package com.spring.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.hibernate.entity.Customer;

@Repository
public class DBARepository
{
	@Autowired
	SessionFactory factory;
	
	public DBARepository() {
		
	}
	
	public List<Customer> getData()
	{
		Session session = factory.getCurrentSession();
		try {
			List<Customer> data = session.createQuery("from Customer").getResultList();
			System.out.println("The list of values are " + data);
			return data;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String InsertData(Customer customer)
	{
		System.out.println(customer);
		Session session = factory.getCurrentSession();
		try {
			session.saveOrUpdate(customer);
			return "Success";
		}catch(Exception e) {
			e.printStackTrace();
		return "Failed";	
		}
	}
	public Customer getDataForUpdate(int id)
	{
		Session session = factory.getCurrentSession();
		try {
			Customer data = session.get(Customer.class,id);
			System.out.println("The list of values are TEST" + data);
			return data;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String deleteRepo(int id) {
		System.out.println("TEST REPO");
		Session session = factory.getCurrentSession();
		try {
			session.createQuery("delete from Customer where id =" + id).executeUpdate();
			return "Success";
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed";
		}
	}
}
