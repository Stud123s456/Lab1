package by.bsuir.insurance.entity.obj;

import by.bsuir.insurance.helper.ServletHelper;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentSchedule {

    private String dateStart;
    private String dateEnd;
    private int declarationId;      //declarationId
    private int insuranceOptionId;  //программа
    private int contractTimeId;     //время действия контракта
    private int periodId;           //график выплат
    private int currencyId;         //валюта
    private double sumInsured;      //страховая сумма
    private double sumAmount;       //общая сумма к выплате
    private double amount;          //единовременная сумма к выплате

    public PaymentSchedule(int declarationId, int insuranceOptionId, int contractTimeId, int currencyId,
                           int periodId, double sumInsured) {
        this.declarationId = declarationId;
        this.insuranceOptionId = insuranceOptionId;
        this.contractTimeId = contractTimeId;
        this.currencyId = currencyId;
        this.periodId = periodId;
        this.sumInsured = sumInsured;
    }

    public void calculate(){
        dateStart = ServletHelper.getLocalDate();
        int numMonths = ContractTime.getMonthsFromId(contractTimeId);
        dateEnd = ServletHelper.getLocalEndDate(numMonths);

        double rate = InsuranceOptionId.getValueFromId(insuranceOptionId);
        sumAmount = roundValue(sumInsured*rate);
        int value = Period.getValueFromTypePeriod(periodId, numMonths);
        amount = roundValue(sumAmount / value);

        switch (contractTimeId) {
            case 2:
                //1/6 месяцев
                if(contractTimeId == ContractTime.TIME2.getId()){
                    sumAmount *= 6;
                    amount = roundValue(sumAmount / value);
                }
                break;
            case 4:
                //1/3 года
                if(contractTimeId == ContractTime.TIME4.getId()){
                    sumAmount *= 3;
                    amount = roundValue(sumAmount / value);
                }
                break;
            default:
                break;
        }
    }

    private static double roundValue(double value){
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public double getSumAmount() {
        return sumAmount;
    }

    public double getAmount() {
        return amount;
    }
}
