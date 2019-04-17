package ac.za.cput.factories.employeefactory;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.util.Misc;

public class ManagerFactory {

    public static Manager getManager(String name, String surname, double salary)
    {
        return new Manager.Builder().name(name)
                .surname(surname)
                .salary(salary)
                .empid(Misc.generateId())
                .build();


    }

}
