package ac.za.cput.factories.tablefactory;

import ac.za.cput.domains.table.Table;
import ac.za.cput.util.Misc;

public class TableFactory {

    private String tableID;
    private int capacity;
    private boolean isavailable;

    public static Table getGuest(int capacity,boolean isavailable)
    {
        return new Table.Builder().capacity(capacity)
                .isavailable(isavailable)
                .tableID(Misc.generateId())
                .build();


    }
}
