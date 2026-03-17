package za.ac.cput.Factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class EmployeeFactory {
    private static Employee createEmployee(String employeeNumber,String firstName,
                                           String lastName,String email,double salary, LocalDate dateOfBirth,Address address){

        if(Helper.isEmptyorNull(employeeNumber)||
                Helper.isEmptyorNull(firstName)
        ){
            return null;
        }

        if(!Helper.IsValidEmail(email)){
            return null;
        }

        return new Employee.Builder()
                .SetEmployeeNumber(employeeNumber)
                .SetFirstName(firstName)
                .SetLastName(lastName)
                .SetEmail(email)
                .SetSalary(salary)
                .SetDateOfBirth(dateOfBirth)
                .SetAddress(address)
                .build();
    }
}
