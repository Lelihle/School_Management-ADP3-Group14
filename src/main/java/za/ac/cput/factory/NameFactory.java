package za.ac.cput.factory;


import za.ac.cput.domain.Name;
import za.ac.cput.util.Helper;

public class NameFactory {
    public static Name build (String firstName, String middleName, String surname){
        Helper.checkStringParam("firstName", firstName);
        Helper.checkStringParam("middleName", middleName);
        Helper.checkStringParam("surname", surname);
        return new Name.Builder().firstName(firstName)
                .middleName(middleName)
                .surname(surname)
                .build();
    }

    public static Name.NameId build(Name name){
        return new Name.NameId(name.getFirstName(), name.getMiddleName(), name.getSurname());
    }
}