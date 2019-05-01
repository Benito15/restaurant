package ac.za.cput.factory.paymentfactory;

import ac.za.cput.domains.payment.Check;

public class CheckFactory {


    public static Check getCheck(String name, String bankID)
    {
        return new Check.Builder().name(name)
                .bankID(bankID)
                .build();


    }

}
