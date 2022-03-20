package by.bsuir.insurance.entity.obj;

public class Declaration {

    private int id;                 //id порядковый
    private String fullName;        //ФИО
    private String contact;         //Телефон/почта
    private String address;         //Адрес/город
    private int insuranceOptionId;  //Вариант страхования: InsuranceOption
    private int periodId;           //Порядок выплаты: Period
    private int contractTimeId;     //Срок действия договора: ContractTime
    private int currencyId;         //Валюта страховой суммы: Currency
    private double sumInsured;      //Страховая сумма
    private String date;            //Дата

    private int clientId;           //id клиента
    private int employeeId;         //id сотрудника

    public Declaration() {}

    public Declaration(String fullName, String contact, String address,
                       int insuranceOptionId, int periodId, int contractTimeId, int currencyId,
                       double sumInsured, String date, int clientId, int employeeId) {
        this.fullName = fullName;
        this.contact = contact;
        this.address = address;
        this.insuranceOptionId = insuranceOptionId;
        this.periodId = periodId;
        this.contractTimeId = contractTimeId;
        this.currencyId = currencyId;
        this.sumInsured = sumInsured;
        this.date = date;
        this.clientId = clientId;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getInsuranceOptionId() {
        return insuranceOptionId;
    }

    public void setInsuranceOptionId(int insuranceOptionId) {
        this.insuranceOptionId = insuranceOptionId;
    }

    public int getContractTimeId() {
        return contractTimeId;
    }

    public void setContractTimeId(int contractTimeId) {
        this.contractTimeId = contractTimeId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

}
