package by.bsuir.insurance.entity.obj;

import lombok.Data;

@Data
public class Client {

    private int id;             //id клиента
    private String fullname;    //ФИО
    private String contact;     //phone/mail
    private String address;     //город/адрес

    public Client() {
        this.id = 0;
        this.fullname = "";
        this.contact = "";
        this.address = "";
    }

    public Client(int id, String fullname, String contact, String address) {
        this.id = id;
        this.fullname = fullname;
        this.contact = contact;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("ФИО: ").append(fullname)
                .append("\n Контактная информация: ").append(contact)
                .append("\n Адрес: ").append(address);
        return builder.toString();
    }
}
