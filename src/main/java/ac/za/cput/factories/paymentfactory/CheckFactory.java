package ac.za.cput.factories.paymentfactory;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.util.Misc;

public class CheckFactory {


    public static Check getCheck(String name, String bankID)
    {
        return new Check.Builder().name(name)
                .bankID(bankID)
                .build();


    }

}
