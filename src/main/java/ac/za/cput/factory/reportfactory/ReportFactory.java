package ac.za.cput.factory.reportfactory;

import ac.za.cput.domains.report.Report;
import ac.za.cput.util.Misc;

import java.util.Date;

public class ReportFactory {



    public static Report getReport(Date dte,String description)
    {
        return new Report.Builder().dte(dte)
                .description(description)
                .repID(Misc.generateId())
                .empID(Misc.generateId())
                .build();


    }

}
