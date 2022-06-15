package za.ac.cput.factory;
/*AddressFactoryTest.java
Factory test for the Address
Author: 214258041_Lelihle Gazi
 13/06/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
        public void buildWithSuccess() {
        Address address = AddressFactory.build("B8", "Chelsea", "17", "Avonmouth Crescent", 7441, new City());
        System.out.println(address.getUnitNumber() + " " + address.getComplexName() + " " + address.getStreetNumber() + " " + address.getStreetName() + " " + address.getPostalCode() + " ");
        assertNotNull(address);
    }
    @Test
        public void buildWithError() {
        City city = new City();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> AddressFactory
                    .build("B4","Nirvana",null, "Wood Drive", 7785, city));

            String exceptionMessage = exception.getMessage();
            System.out.println("exceptionMessage");
            assertSame("Street Number is required",exceptionMessage);

        }
    @Test
        public void buildWithErrorOnPostalCode(){
        City city = new City();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> AddressFactory
                .build("B4","Nirvana","80", "Wood Drive", 10000, city));

        String exceptionMessage = exception.getMessage();
        System.out.println("exceptionMessage");
        assertSame("Postal Code must be between 1000 and 9999",exceptionMessage);

    }
    }

