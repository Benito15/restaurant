package ac.za.cput.factories.paymentfactory;

import ac.za.cput.domains.payment.Cash;

public class CashFactory {



    public static Cash getCash(double amount)
    {
        return new Cash.Builder().amount(amount)
                .build();


    }
}
