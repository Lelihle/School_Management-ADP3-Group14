/* StudentFactoryTest.java
Author: Chante Lewis:216118395
12/06/2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    public static Name name = NameFactory.build("Chante", "Alicia", "Lewis");

    @Test
    public void buildWithSucccess() {
        Student student = StudentFactory.build("216118395", "chantel@yahoo.com", name);
        System.out.println(student);
        assertNotNull(student);
    }

    @Test
    public void buildWithErrror() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentFactory.build(null, "chantel@yahoo.com", name));

        String exceptionMessage = exception.getMessage();
        assertSame("StudentId is required", exceptionMessage);

    }
}