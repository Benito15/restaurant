package ac.za.cput.factory.proofofpayment.paymentfactory;

import ac.za.cput.domains.payment.Check;



public class CheckFactory {


    public static Check getCheck( String orderID, double amount, String bankID,String name)
    {
        return  new Check(orderID,  amount, bankID, name);

    }

}
