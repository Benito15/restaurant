package ac.za.cput.factories.employeefactory;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.util.Misc;

public class CheffFactory {

    public static Cheff getCheff(String name, String surname, double salary)
    {
        return new Cheff.Builder().name(name)
                .surname(surname)
                .salary(salary)
                .empid(Misc.generateId())
                .build();


    }


}
