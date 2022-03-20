package by.bsuir.insurance.entity.obj;

public enum Period {

    PERIOD1(1, "Единовременно"),
    PERIOD2(2, "В 2 этапа"),
    PERIOD3(3, "Ежеквартально");

    private int id;
    private String name;

    Period(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static int getValueFromTypePeriod(int n, int numMonths){
        switch (n) {
            case 1:
                return PERIOD1.getId();
            case 2:
                return PERIOD2.getId();
            default:
                return (numMonths == 1) ? 1: numMonths / 3;
        }
    }

    public static String getNameFromId(int n){
        switch (n) {
            case 1:
                return PERIOD1.getName();
            case 2:
                return PERIOD2.getName();
            default:
                return PERIOD3.getName();
        }
    }
}
