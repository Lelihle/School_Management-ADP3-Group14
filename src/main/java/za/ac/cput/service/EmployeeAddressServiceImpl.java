package za.ac.cput.service;
/*
Implementation of the Service for the EmployeeAddress
Author: Abdul Aleem Chilwan
StudNo: 220108447
Date:june 2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.repository.EmployeeAddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService {

    private final EmployeeAddressRepository repository;

    @Autowired
    public EmployeeAddressServiceImpl(EmployeeAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeAddress> findAll() {
        return this.repository.findAll();

    }
    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String id) {
        return Optional.of(this.repository.getById(id));
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }
}