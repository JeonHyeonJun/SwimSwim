package service;

import java.util.List;

import model.Customer;

public interface CustormerService {
	public boolean idCheck(String id);
	public boolean join(Customer customer);
	public boolean delete(String id);
	public List<Customer> getAllCustomer();
}
