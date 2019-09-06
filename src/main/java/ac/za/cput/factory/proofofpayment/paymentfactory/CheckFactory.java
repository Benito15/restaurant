package ac.za.cput.factory.proofofpayment.paymentfactory;

import ac.za.cput.domains.proofofpayment.payment.Check;

public class CheckFactory {


    public static Check getCheck(String name, String bankID)
    {
        return new Check.Builder().name(name)
                .bankID(bankID)
                .build();


    }

}
