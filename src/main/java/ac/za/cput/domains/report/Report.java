package ac.za.cput.domains.report;

import java.util.Date;

public class Report {

    private String repID, empID;
    private Date dte;

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

    public Date getDte() {
        return dte;
    }

    public String getEmpID() {
        return empID;
    }

    public static class Builder
    {
        private String repID, empID;
        private Date dte;

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

        public Builder dte(Date dte)
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
