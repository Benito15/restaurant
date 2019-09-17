package ac.za.cput.domains.report;

import java.util.Date;

public class Report {

    private String repID, empID,description;
    private Date dte;

    private Report(){}

    public Report(Builder builder)
    {
        this.repID = builder.repID;
        this.empID= builder.empID;
        this.dte = builder.dte;
        this.description = builder.description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRepID(String repID) {
        this.repID = repID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public void setDte(Date dte) {
        this.dte = dte;
    }

    public static class Builder
    {
        private String repID, empID,description;
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

        public Builder description(String description)
        {
            this.description = description;
            return this;
        }

        public Builder copy(Report report) {
            this.repID = report.repID;
            this.empID= report.empID;
            this.dte = report.dte;
            this.description = report.description;
            return this;
        }

        public Report build()
        {
            return new Report(this);
        }

     }

    @Override
    public String toString() {
        return "\n Report{" +
                "repID= " + repID + "\n" +
                "Datte= " + dte + "\n" +
                "empID= " + empID + "\n"+
                "Description= " + description+ "\n";
    }
}
