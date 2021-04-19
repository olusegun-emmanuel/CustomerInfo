package com.customerinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customerinfo.beans.Customerinfo;

public interface CustomerInfoRepository extends JpaRepository<Customerinfo, Integer>{

}
