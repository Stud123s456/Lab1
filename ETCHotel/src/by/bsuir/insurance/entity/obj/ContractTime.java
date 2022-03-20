package by.bsuir.insurance.entity.obj;

public enum ContractTime {

    TIME1(1, "1 месяц", 1),
    TIME2(2, "6 месяцев", 6),
    TIME3(3, "1 год", 12),
    TIME4(4,"3 года", 36);

    private int id;
    private String name;
    private int numMonths;

    ContractTime(int id, String name, int numMonths) {
        this.id = id;
        this.name = name;
        this.numMonths = numMonths;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumMonths() {
        return numMonths;
    }

    public static int getMonthsFromId(int n){
        switch (n) {
            case 1:
                return TIME1.getNumMonths();
            case 2:
                return TIME2.getNumMonths();
            case 4:
                return TIME4.getNumMonths();
            default:
                return TIME3.getNumMonths();
        }
    }
}
