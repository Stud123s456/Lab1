package by.bsuir.insurance.entity.obj;

public enum ProgramType {
    TYPE1(1, "Комплексное страхование квартиры онлайн"),
    TYPE2(2, "Комплексное страхование квартиры и дома онлайн"),
    TYPE3(3, "Страхование дома и имущества"),
    TYPE4(4, "Комплексное краткосрочное страхование квартиры онлайн");

    private int id;
    private String name;

    ProgramType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
