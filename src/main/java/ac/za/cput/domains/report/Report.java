package ac.za.cput.domains.report;

public class Report {

    private String repID,dte, empID;

    private Report(){}

    private Report(Builder builder)
    {
        this.repID = builder.repID;
        this.empID= builder.empID;
        this.dte = builder.dte;

    }

    public String getRepID() {
        return repID;
    }

    public String getDte() {
        return dte;
    }

    public String getEmpID() {
        return empID;
    }

    public static class Builder
    {
        private String repID,dte, empID;

        public Builder repID(String repID)
        {
            this.repID = repID;
            return this;

        }

        public Builder empID(String empID)
        {
            this.empID = empID;
            return this;

        }

        public Builder dte(String dte)
        {
            this.dte = dte;
            return this;

        }

        public Report build()
        {
            return new Report(this);
        }

    }

    @Override
    public String toString() {
        return "Report{" +
                "repID='" + repID + '\'' +
                ", dte='" + dte + '\'' +
                ", empID='" + empID + '\'' +
                '}';
    }
}
