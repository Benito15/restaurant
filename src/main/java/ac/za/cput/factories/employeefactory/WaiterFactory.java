package ac.za.cput.factories.employeefactory;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.util.Misc;

public class WaiterFactory {


    public static Waiter getWaiter(String name, String surname, double salary)
    {
        return new Waiter.Builder().name(name)
                .surname(surname)
                .salary(salary)
                .empid(Misc.generateId())
                .build();


    }


}
