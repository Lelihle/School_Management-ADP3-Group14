package za.ac.cput.service;
/*
Interface of the Service for the EmployeeAddress
Author: Abdul Aleem Chilwan
StudNo: 220108447
Date:june 2022
 */
import za.ac.cput.domain.EmployeeAddress;

import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress,String> {
    List<EmployeeAddress> findAll();

    void delete(String id);
}
