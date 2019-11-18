package main.java.paymentcalculation;

import java.math.BigDecimal;

public class InterestRateCalculationImpl implements InterestRateCalculation {
    private static final double PERCENT_CONST = 12.0;
    @Override
    public double calculateInterestRate(BigDecimal amount, int term, PaymentType paymentType) {
        return PERCENT_CONST;
    }
}
