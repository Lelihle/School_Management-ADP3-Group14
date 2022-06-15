package za.ac.cput.factory;
/* AddressFactory.java
Factory for the Address
Author: 214258041_Lelihle Gazi
10/06/2022
 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, int postalCode, City city) {

        if(streetNumber == null || streetNumber=="") throw new IllegalArgumentException("Street Number is required");
        if(streetName == null || streetName=="") throw new IllegalArgumentException("Street Name is required");
        if(postalCode <= 1000 || postalCode >= 9999) throw new IllegalArgumentException("Postal Code must be between 1000 and 9999");
        if(city == null) throw new IllegalArgumentException("City is required");

        return new Address
                .Builder()
                .setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city)
                .build();
    }
}

