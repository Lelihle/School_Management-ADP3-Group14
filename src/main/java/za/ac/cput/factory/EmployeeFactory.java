package za.ac.cput.factory;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 13 June 2022
School Management
 */
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

public class EmployeeFactory {
    private static final String validation = "^(.+)@(.+)$";

    public static Employee builder(String staffId, String email, Name name){

        if(staffId.isEmpty() || !email.matches(validation))
            throw new IllegalArgumentException("Invalid email");
        return new Employee.Builder()
                .staffId(staffId)
                .email(email)
                .name(name)
                .build();
    }
}
