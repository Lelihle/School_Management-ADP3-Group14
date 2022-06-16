package za.ac.cput.factory;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 14 June 2022
School Management
 */
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    Name name1 = new Name.Builder().firstName("dev").middleName("Elopers").surname("testers").build();
    Name name2 = new Name.Builder().firstName("peranice").middleName("aluntova").surname("sheiva").build();

    ArrayList<Employee> employee = new ArrayList<>();
    private final Employee employee1 = EmployeeFactory.builder("761A","testers@gmail.com", name1);
    private final Employee employee2 = EmployeeFactory.builder("564B","perals@gmail.com", name2);

    @Test
    void builder() {
        employee.add(employee1);
        System.out.println(employee.get(0));
        employee.add(employee2);
        System.out.println(employee.get(1));
        assertNotNull(employee);
    }

}