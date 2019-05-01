package ac.za.cput.factory.reportfactory;

import ac.za.cput.domains.report.Report;
import ac.za.cput.util.Misc;

import java.util.Date;

public class ReportFactory {

    private String repID,empID;
    private Date dte;

    public static Report getReport(Date dte)
    {
        return new Report.Builder().dte(dte)
                .repID(Misc.generateId())
                .empID(Misc.generateId())
                .build();


    }

}
