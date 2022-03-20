package by.bsuir.insurance.entity.obj;

public class Program {

    private int programTypeId;   //id программы страхования
    private String content;      //содержание
    private String name;         //наименование
    private String objects;      //объекты для страхования

    public Program(){
        this.programTypeId = 0;
        this.content = "";
        this.name = "";
    }

    public Program(int programTypeId, String content, String name) {
        this.programTypeId = programTypeId;
        this.content = content;
        this.name = name;
    }

    public int getProgramTypeId() {
        return programTypeId;
    }

    public void setProgramTypeId(int programTypeId) {
        this.programTypeId = programTypeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjects() {
        return objects;
    }

    public void setObjects(String objects) {
        this.objects = objects;
    }

    public String toString(){
        return String.join("\n",
                " Программа: "+name,
                " Содержание: "+content);
    }
}
