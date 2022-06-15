package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;

public class EmployeeAddressFactory {
    public static EmployeeAddress build(String staffId, Address address){
        //StringHelper.checkStringParam("staffId", staffId);
        //StringHelper.checkStringParam("address", address);

        return new EmployeeAddress.Builder().StaffId(staffId).Address(address).build();
    }

    public static EmployeeAddress.EmployeeAddressId buildId(EmployeeAddress employeeAddress){
        return new EmployeeAddress.EmployeeAddressId(employeeAddress.getStaffId(),
                employeeAddress.getAddress());
    }
}