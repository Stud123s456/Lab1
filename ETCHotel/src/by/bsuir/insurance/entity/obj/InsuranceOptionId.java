package by.bsuir.insurance.entity.obj;

/* 'Program' */
public enum InsuranceOptionId {

    OPTION1(1, "Комплексное страхование квартиры онлайн", "program1"),
    OPTION2(2, "Комплексное страхование квартиры и дома онлайн", "program2"),
    OPTION3(3, "Страхование дома и имущества", "program3"),
    OPTION4(4, "Комплексное краткосрочное страхование квартиры онлайн", "program4");

    private int id;
    private String name;
    private String param;
    private static double d1 = 0.0032;
    private static double d2 = 0.0063;
    private static double d3 = 0.0057;
    private static double d4 = 0.00048;

    InsuranceOptionId(int id, String name, String param) {
        this.id = id;
        this.name = name;
        this.param = param;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParam() {
        return param;
    }

    public static double getValueFromId(int n){
        switch (n) {
            case 1:
                return d1;
            case 2:
                return d2;
            case 3:
                return d3;
            default:
                return d4;
        }
    }

    public static String getParamFromId(int n){
        switch (n) {
            case 1:
                return OPTION1.getParam();
            case 2:
                return OPTION2.getParam();
            case 3:
                return OPTION3.getParam();
            default:
                return OPTION4.getParam();
        }
    }

    public static String getNameFromId(int n){
        switch (n) {
            case 1:
                return OPTION1.getName();
            case 2:
                return OPTION2.getName();
            case 3:
                return OPTION3.getName();
            default:
                return OPTION4.getName();
        }
    }
}
