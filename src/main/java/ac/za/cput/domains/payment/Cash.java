package ac.za.cput.domains.payment;



public class Cash implements Payment {
    private double amount;

    private Cash(){}
    private Cash(Builder builder)
    {
        this.amount = builder.amount;


    }

    @Override
    public String dte() {
        return "This is the date";
    }

    @Override
    public double payAmount() {
        return 0;
    }

    public double getAmount() {
        return amount;
    }

    public static class Builder
    {
        private double amount;

        public Builder amount(double amount)
        {
            this.amount = amount;
            return this;

        }
        public Cash build()
        {
            return new Cash(this);
        }

    }

}
