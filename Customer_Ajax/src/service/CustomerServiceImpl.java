package service;

import java.util.List;

import dao.CustomerDao;
import model.Customer;

public class CustomerServiceImpl implements CustormerService{
	CustomerDao dao = CustomerDao.getInstance();
	
	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return dao.selectOne(id) == null ? true : false; 
	}

	@Override
	public boolean join(Customer customer) {
		// TODO Auto-generated method stub
		return dao.insertCustomer(customer);
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	
}
