package paymentcalculation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Payment {
    private LocalDate paymentDate;
    private BigDecimal amountOfPayment;
    private BigDecimal amountOfMainDebtRepayment;
    private BigDecimal amountOfInterestRepayment;

    public Payment(LocalDate paymentDate, BigDecimal amountOfPayment, BigDecimal amountOfMainDebtRepayment, BigDecimal amountOfInterestRepayment) {
        this.paymentDate = paymentDate;
        this.amountOfPayment = amountOfPayment;
        this.amountOfMainDebtRepayment = amountOfMainDebtRepayment;
        this.amountOfInterestRepayment = amountOfInterestRepayment;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(BigDecimal amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    public BigDecimal getAmountOfMainDebtRepayment() {
        return amountOfMainDebtRepayment;
    }

    public void setAmountOfMainDebtRepayment(BigDecimal amountOfMainDebtRepayment) {
        this.amountOfMainDebtRepayment = amountOfMainDebtRepayment;
    }

    public BigDecimal getAmountOfInterestRepayment() {
        return amountOfInterestRepayment;
    }

    public void setAmountOfInterestRepayment(BigDecimal amountOfInterestRepayment) {
        this.amountOfInterestRepayment = amountOfInterestRepayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(amountOfPayment, payment.amountOfPayment) &&
                Objects.equals(amountOfMainDebtRepayment, payment.amountOfMainDebtRepayment) &&
                Objects.equals(amountOfInterestRepayment, payment.amountOfInterestRepayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentDate, amountOfPayment, amountOfMainDebtRepayment, amountOfInterestRepayment);
    }

    @Override
    public String toString() {
        return "Дата платежа: " + paymentDate.getDayOfMonth() + " "
                + String.format("%-9s", paymentDate.getMonth()) + " " + paymentDate.getYear() +
                ", сумма платежа: " + amountOfPayment +
                ", сумма погашения основного долга: " + amountOfMainDebtRepayment +
                ", сумма погашения процентов " + amountOfInterestRepayment;
    }
}
