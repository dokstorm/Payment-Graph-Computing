package main.java.paymentcalculation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditDetail {

    private double interestRate;
    private int term;
    private BigDecimal amount;
    private PaymentType paymentType;
    private LocalDate creditExtraditionDate;

    public CreditDetail(double interestRate, int term, BigDecimal amount, PaymentType paymentType,
                        LocalDate creditExtraditionDate) {
        this.interestRate = interestRate;
        this.term = term;
        this.amount = amount;
        this.paymentType = paymentType;
        this.creditExtraditionDate = creditExtraditionDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDate getCreditExtraditionDate() {
        return creditExtraditionDate;
    }

    public void setCreditExtraditionDate(LocalDate creditExtraditionDate) {
        this.creditExtraditionDate = creditExtraditionDate;
    }
}


