package paymentcalculation;

import paymentcalculation.PaymentType;

import java.math.BigDecimal;

public interface InterestRateCalculation {
    double calculateInterestRate(BigDecimal amount, int term, PaymentType paymentType);
}
