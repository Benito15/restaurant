package ac.za.cput.domains.employee;

public class Cheff extends Employee {



    private Cheff(Builder builder){
       super(builder);
    }

    public static class Builder extends Employee.Builder{
        public Cheff build()
        {
            return new Cheff(this);
        }
    }

    @Override
    public String toString() {
        return " \n Cheff{" +
                "Empid= " + empid + "\n"+
                "Name= " + name + "\n"+
                "Surname= " + surname + "\n" +
                "Salary= " + salary +"\n";
    }
}
