package by.bsuir.insurance.service;

import by.bsuir.insurance.entity.obj.Declaration;
import by.bsuir.insurance.entity.obj.PaymentSchedule;

public class CalcService {

    public static PaymentSchedule start(Declaration declaration){
        PaymentSchedule schedule = new PaymentSchedule(
                declaration.getId(),
                declaration.getInsuranceOptionId(),
                declaration.getContractTimeId(),
                declaration.getCurrencyId(),
                declaration.getPeriodId(),
                declaration.getSumInsured());
        schedule.calculate();
        return schedule;
    }
}
