package ac.za.cput.factories.paymentfactory;

import ac.za.cput.domains.payment.Credit;
import ac.za.cput.util.Misc;

public class CreditFactory {



public static Credit getCredit(String name, String cardID)
    {
        return new Credit.Builder().name(name)
                .cardID(cardID)

                .build();


    }

}
