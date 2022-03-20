package by.bsuir.insurance.entity;

import by.bsuir.insurance.entity.obj.*;

public class Contract {

    private int id;             //id договора
    private int clientId;       //id клиента
    private int programTypeId;  //тип программы
    private int currencyId;     //валюта
    public double sum;          //сумма страхования
    public double sumPayment;   //сумма платежа
    private String endDate;     //дата окончания

    public String fullName;
    public String programmName;
    public String currencyName;
    public String objects;
    private int employeeId;
    private String periodName;

    public Contract(){}

    public Contract(int id, int clientId, int programTypeId, int currencyId, double sum, double sumPayment,
                    String endDate, String fullName, String programmName) {
        this.id = id;
        this.clientId = clientId;
        this.programTypeId = programTypeId;
        this.currencyId = currencyId;
        this.sum = sum;
        this.sumPayment = sumPayment;
        this.endDate = endDate;
        this.fullName = fullName;
        this.programmName = programmName;
    }

    public void setParametrs(Declaration declaration, Client client, PaymentSchedule schedule){
        this.clientId = client.getId();
        this.programTypeId = declaration.getInsuranceOptionId();
        this.currencyId = declaration.getCurrencyId();
        this.sum = schedule.getSumAmount();
        this.sumPayment = schedule.getAmount();
        this.endDate = schedule.getDateEnd();
        this.fullName = client.getFullname();
        this.programmName = InsuranceOptionId.getNameFromId(programTypeId);
        this.currencyName = Currency.getNameFromId(currencyId);
        this.periodName = Period.getNameFromId(declaration.getPeriodId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProgramTypeId() {
        return programTypeId;
    }

    public void setProgramTypeId(int programTypeId) {
        this.programTypeId = programTypeId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getObjects() {
        return objects;
    }

    public void setObjects(String objects) {
        this.objects = objects;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public double getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(double sumPayment) {
        this.sumPayment = sumPayment;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProgrammName() {
        return programmName;
    }

    public void setProgrammName(String programmName) {
        this.programmName = programmName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }
}
