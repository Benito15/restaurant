package ac.za.cput.factory.paymentfactory;

import ac.za.cput.domains.payment.Credit;

public class CreditFactory {



public static Credit getCredit(String name, String cardID)
    {
        return new Credit.Builder().name(name)
                .cardID(cardID)

                .build();


    }

}
