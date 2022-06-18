/* StudentAddressFactory.java
Author: Chante Lewis:216118395
12/06/2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.util.Helper;

public class StudentAddressFactory {

    public static StudentAddress build(String studentId, Address address) {

        Helper.isEmptyOrNull("studentId");
        Helper.isEmptyOrNull("address");

        Helper.checkStringParam("studentId", studentId);

        Helper.setEmptyIfNull("studentId");
        Helper.setEmptyIfNull("address");

        return new StudentAddress.Builder().studentId(studentId).address(address).build();
    }
}
