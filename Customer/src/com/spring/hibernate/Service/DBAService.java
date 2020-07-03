package com.spring.hibernate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.DAO.DBARepository;
import com.spring.hibernate.entity.Customer;
import com.spring.hibernate.entity.CustomerValidation;

@Service
public class DBAService 
{
	@Autowired
	DBARepository dbarepository;
	
	@Autowired
	Customer customer;
	
	public DBAService() {
		
	}
	
	@Transactional
	public List<Customer> Data()
	{
		return dbarepository.getData();
	}
	
	@Transactional
	public String insertDBA(CustomerValidation tempCustomer)
	{
		System.out.println("Inside the Service method");
		customer.setId(tempCustomer.getId());
		customer.setFirstName(tempCustomer.getFirstName());
		customer.setLastName(tempCustomer.getLastName());
		customer.setEmail(tempCustomer.getEmail());
		
		String result = dbarepository.InsertData(customer);
		return result;
		
	}
	@Transactional
	public Customer getData(int id)
	{
		return dbarepository.getDataForUpdate(id);
	}

	@Transactional
	public String delete(int id) {
		return dbarepository.deleteRepo(id);
	}
}
