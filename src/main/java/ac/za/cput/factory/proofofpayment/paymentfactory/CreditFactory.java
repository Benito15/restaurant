package ac.za.cput.factory.proofofpayment.paymentfactory;

import ac.za.cput.domains.proofofpayment.payment.Credit;

public class CreditFactory {



public static Credit getCredit(String name, String cardID)
    {
        return new Credit.Builder().name(name)
                .cardID(cardID)

                .build();


    }

}
