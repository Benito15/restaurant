package ac.za.cput.factory.proofofpayment.paymentfactory;

import ac.za.cput.domains.payment.Credit;

public class CreditFactory {



public static Credit getCredit(String orderID, double amount,String cardID,String name)
    {

        return  new Credit(orderID, amount, cardID, name);


    }

}
