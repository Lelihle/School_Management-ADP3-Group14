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
    public static City build (String id,String name, Country country){
        Helper.checkStringParam("id", id);
        Helper.checkStringParam("name", name);
        Helper.isEmptyOrNull(name);
        Helper.checkId(id);
        return new City.Builder().setId(id).setName(name).setCountry(country).build();

    }
}
