package com.customerinfo.controller;

import com.customerinfo.beans.CustomerInfoList;
import com.customerinfo.beans.Customerinfo;
import com.customerinfo.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
