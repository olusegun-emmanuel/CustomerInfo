package com.customerinfo.repository;

import com.customerinfo.beans.Customerinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<Customerinfo, Integer> {

}
