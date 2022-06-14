package za.ac.cput.factory;

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
