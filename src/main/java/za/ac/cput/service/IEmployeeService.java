package za.ac.cput.service;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 13 June 2022
School Management
 */
import za.ac.cput.domain.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee,String> {
    public List<Employee> readAll();
}
