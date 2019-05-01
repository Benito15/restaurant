package ac.za.cput.factory.employeefactory;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.util.Misc;

public class CheffFactory {

    public static Cheff getCheff(String name, String surname, double salary)
    {
        return (Cheff) new Cheff.Builder().name(name)
                .surname(surname)
                .salary(salary)
                .empid(Misc.generateId())
                .build();


    }


}
