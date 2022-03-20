package by.bsuir.insurance.entity.obj;

public enum Currency {

    BYN(1, "BYN"),
    USD(2, "USD");

    private int id;
    private String name;

    Currency(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String getNameFromId(int n){
        switch (n) {
            case 1:  return BYN.getName();
            default: return USD.getName();
        }
    }
}
