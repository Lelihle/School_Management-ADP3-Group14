package za.ac.cput.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student build(String studentId, String email) {

        Helper.isEmptyOrNull("studentId");// enforce other is replaced with empty string
        Helper.isEmptyOrNull("email");
        // Helper.isEmptyOrNull("name");


        Helper.checkStringParam("studentId", studentId);// enforce mandatory
        Helper.checkStringParam("email", email);
        // Helper.checkStringParam("name", name);

        if(!Helper.isValidEmail(email))
            return null;

        return new Student.Builder().studentId(studentId).email(email).build();
    }
}