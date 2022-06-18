/* StudentAddressFactoryTest .java
Author: Chante Lewis:216118395
12/06/2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {
    public static Country country = CountryFactory.build("20111","South African");
    public static City city = CityFactory.build("10111","Saldanha",country);
    public static Address address = AddressFactory.build("12","seacrest","104","Flurry",7395,city);

    @Test
    public void buildWithSucccess(){
        StudentAddress studentAddress = StudentAddressFactory.build("216118395", address);
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }
    @Test
    public void buildWithErrror(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory.build(null,address));
        String exceptionMessage = exception.getMessage();
        assertSame("StudentId is required",exceptionMessage);
    }
}