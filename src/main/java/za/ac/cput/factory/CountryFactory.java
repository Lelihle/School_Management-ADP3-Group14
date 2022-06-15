/*
Entity for the Country factory
Author: Moegammad Tasreeq Adams : 216173027
Date:June 2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Country;
import za.ac.cput.util.Helper;

public class CountryFactory {
    public static Country build(String id,String name){
        Helper.checkStringParam("id",id);
        Helper.checkStringParam("name",name);
        Helper.isEmptyOrNull(name);
        Helper.checkId(id);
        return new Country.Builder().setId(id).setName(name).build();
    }
}
