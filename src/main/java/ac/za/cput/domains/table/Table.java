package ac.za.cput.domains.table;

public class Table {

    private String tableID;
    private int capacity;
    private boolean isavailable;

private Table(){}

    private Table(Builder builder)
    {
        this.tableID = tableID;
        this.capacity = capacity;
        this.isavailable = isavailable;
    }

    public String getTableID() {
        return tableID;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isIsavailable() {
        return isavailable;
    }

    public static class Builder
    {
        private String tableID;
        private int capacity;
        private boolean isavailable;

        public Builder tableID(String tableID)
        {
            this.tableID=tableID;
            return this;

        }

    public Builder capacity(int capacity)
        {
            this.capacity=capacity;
            return this;

        }

        public Builder isavailable(boolean isavailable)
        {
            this.isavailable =isavailable;
            return this;

        }

        public Table build()
        {
            return new Table(this);
        }

    }


}
