package ac.za.cput.factory.tablefactory;

import ac.za.cput.domains.table.Table;
import ac.za.cput.util.Misc;

public class TableFactory {



    public static Table getTable(int capacity,boolean isavailable)
    {
        return new Table.Builder().capacity(capacity)
                .isavailable(isavailable)
                .tableID(Misc.generateId())
                .build();


    }
}
