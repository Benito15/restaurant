package ac.za.cput.factory.reportfactory;

import ac.za.cput.domains.report.Report;
import ac.za.cput.util.Misc;

import java.util.Date;

public class ReportFactory {



    public static Report getReport(String dte,String description, String empID)
    {
        return new Report.Builder().dte(dte)
                .description(description)
                .repID(Misc.generateId())
                .empID(empID)
                .build();


    }

}
