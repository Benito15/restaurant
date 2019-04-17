package ac.za.cput.factories.reportfactory;

import ac.za.cput.domains.report.Report;
import ac.za.cput.util.Misc;

public class ReportFactory {

    private String repID,dte, empID;

    public static Report getReport(String dte)
    {
        return new Report.Builder().dte(dte)
                .repID(Misc.generateId())
                .empID(Misc.generateId())
                .build();


    }

}
