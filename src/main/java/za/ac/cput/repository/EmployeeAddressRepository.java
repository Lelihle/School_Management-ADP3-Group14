package za.ac.cput.repository;
/*
Repository for the EmployeeAddress
Author: Abdul Aleem Chilwan
StudNo: 220108447
Date:june 2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.EmployeeAddress;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {

}
