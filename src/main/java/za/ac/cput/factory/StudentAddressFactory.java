package za.ac.cput.factory;

import za.ac.cput.domain.StudentAddress;
import za.ac.cput.util.Helper;

public class StudentAddressFactory {

    public static StudentAddress build(String studentId) {

        Helper.isEmptyOrNull("studentId");
        Helper.checkStringParam("studentId", studentId);
        //Helper.checkStringParam("address",address);
        return new StudentAddress.Builder().studentId(studentId).build();
    }
}
