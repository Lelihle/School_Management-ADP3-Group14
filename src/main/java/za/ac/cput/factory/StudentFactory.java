/* StudentFactory.java
Author: Chante Lewis:216118395
12/06/2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student build(String studentId, String email, Name name) {

        Helper.isEmptyOrNull("studentId");
        Helper.isEmptyOrNull("email");
        Helper.isEmptyOrNull("name");

        Helper.checkStringParam("studentId", studentId);
        Helper.checkStringParam("email", email);

        Helper.isValidEmail("email");

        return new Student.Builder().studentId(studentId).email(email).name(name).build();
    }
}