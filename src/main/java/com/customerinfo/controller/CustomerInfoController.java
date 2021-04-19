package com.customerinfo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.customerinfo.beans.CustomerInfoList;
import com.customerinfo.beans.Customerinfo;
import com.customerinfo.repository.CustomerInfoRepository;

@RestController
@RequestMapping("/info")
public class CustomerInfoController {

	@Autowired
	private CustomerInfoRepository customerInfoRepository;
	
	@RequestMapping("/customer")
	//This method gets all the customer info from the back end
	public CustomerInfoList getCustomerInfo()	{
		CustomerInfoList customerInfoList = new CustomerInfoList();
		List<Customerinfo> custlist = customerInfoRepository.findAll();
		customerInfoList.setCustomerinfo(custlist);
		return customerInfoList;
	}
	
	@RequestMapping("/customer/{id}")
	//This method gets all the customer info based on the id
	public Optional<Customerinfo> getCustomerInfoById(@PathVariable("id") int id)	{
		Optional<Customerinfo> e = customerInfoRepository.findById(id);
		return e;
	}
	
	@PostMapping("/customer")
	//This method saves the customer info
	public String saveCustomerInfo(@RequestBody Customerinfo customerinfo)	{
		customerInfoRepository.save(customerinfo); 
		return "CustomerInfo is created successfully";
	}
	
	
	@DeleteMapping("/customer/{id}")
	//This method deletes the customer info
	public String deleteCustomerInfo(@PathVariable("id") int id){
		Customerinfo custinfo= customerInfoRepository.getOne(id);
		customerInfoRepository.delete(custinfo);
		return "CustomerInfo is deleted successfully";
	}
	
	
	@PutMapping(path="/customer/{id}", consumes = {"application/json"})
	//This method updates the customer info
	public String updateCustomer(@RequestBody Customerinfo custinfo)	{
		customerInfoRepository.save(custinfo);
		return "CustomerInfo is updated successfully";
	}
	
}
