package za.ac.cput.service;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 14 June 2022
School Management
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;
import java.util.*;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository repository;

   @Autowired
   public EmployeeServiceImpl(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(String employeeId) {
        return this.repository.getById(employeeId);
    }

    @Override
    public void delete(String employeeId) {
        this.repository.deleteById(employeeId);
    }

    @Override
    public List<Employee> readAll() {
        return this.repository.findAll();

    }

}
