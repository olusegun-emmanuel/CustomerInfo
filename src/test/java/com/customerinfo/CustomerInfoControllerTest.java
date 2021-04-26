package com.customerinfo;

import com.customerinfo.beans.CustomerInfoList;
import com.customerinfo.beans.Customerinfo;
import com.customerinfo.controller.CustomerInfoController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerInfoControllerTest {

    @Autowired
    CustomerInfoController customerInfoController;
    CustomerInfoList customerInfoList;

    @Test
    @Order(1)
    public void getCustomerInfo_Success(){
        customerInfoList =  customerInfoController.getCustomerInfo();
        List<Customerinfo> customerInfoReturned = customerInfoList.getCustomerinfo();
        System.out.println(customerInfoList.toString());
        assertNotNull(customerInfoList.getCustomerinfo());
        assertEquals(4, customerInfoReturned.size());
    }

    @Test
    @Order(2)
    public void getAddressIdTest_Success(){
        Integer addressId = 1;
        Optional<Customerinfo> customerAddr =  customerInfoController.getCustomerInfoById(addressId);
        assertNotNull(customerAddr);
        assertEquals(1, customerAddr.get().getEmpid());
        assertEquals("Ajay", customerAddr.get().getFirstname());
        assertEquals("D1", customerAddr.get().getId());
    }

    @Test
    @Order(3)
    public void getAddressIdTest_Failure(){
        Integer addressId = 8;
        Optional<Customerinfo> customerAddr =  customerInfoController.getCustomerInfoById(addressId);
        Assertions.assertSame(Optional.empty(), customerAddr);
    }


    @Test
    @Order(4)
    public void addAddress_Success() {
        Customerinfo customerInfo= new Customerinfo();
        customerInfo.setEmpid(4);
        customerInfo.setFirstname("Emmanuel");
        customerInfo.setLastname("Jabagan");
        customerInfo.setId("D1");
        customerInfo.setGrade("B2");
        String customerSaveReturned =  customerInfoController.saveCustomerInfo(customerInfo);
        assertNotNull(customerSaveReturned);
        Assertions.assertSame("CustomerInfo is created successfully", customerSaveReturned);
    }


    @Test
    @Order(5)
    public  void addAddress_AutoIdGeneratedSuccess() {
        Customerinfo customerInfo= new Customerinfo();
        customerInfo.setFirstname("James");
        customerInfo.setLastname("Anjali");
        customerInfo.setId("D4");
        customerInfo.setGrade("C6");
        String customerSaveReturned =  customerInfoController.saveCustomerInfo(customerInfo);
        assertNotNull(customerSaveReturned);
    }


    @Test
    @Order(6)
    public  void updateCustomerAddress_Success() {
        Customerinfo customerInfo= new Customerinfo();
        customerInfo.setEmpid(5);
        customerInfo.setFirstname("James");
        customerInfo.setLastname("Anjali");
        customerInfo.setId("D4");
        customerInfo.setGrade("A1");
        String customerSaveReturned =  customerInfoController.updateCustomer(customerInfo);
        assertNotNull(customerSaveReturned);
        Assertions.assertSame("CustomerInfo is updated successfully", customerSaveReturned);
    }

    @Test
    @Order(7)
    public  void deleteCustomerAddres_Success() {
        Integer addressId = 5;
        String customerDeleted =  customerInfoController.deleteCustomerInfo(addressId);
        Assertions.assertSame("CustomerInfo is deleted successfully", customerDeleted);
    }

}
