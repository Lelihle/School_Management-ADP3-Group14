/*
Entity for the City Factory
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.factory;


import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.util.Helper;

public class CityFactory {
    public static City build (String id,String Name, Country country){
        Helper.checkStringParam("id", id);
        Helper.checkStringParam("name", Name);
        Helper.checkIfObjectNull("Country",country);
        Helper.isEmptyOrNull(Name);
        Helper.checkId(id);
        return new City.Builder().setId(id).setName(Name).setCountry(country).build();

    }
}
