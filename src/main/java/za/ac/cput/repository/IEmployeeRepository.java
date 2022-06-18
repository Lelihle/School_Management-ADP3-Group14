package za.ac.cput.repository;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 13 June 2022
School Management
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    //Question 5
    Optional<Employee> findEmployeeByEmail(String email);
}
