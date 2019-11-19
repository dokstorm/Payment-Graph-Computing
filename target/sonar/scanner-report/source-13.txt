package paymentcalculation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentBuilder {

    private Payment payment = new Payment(LocalDate.now(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);

    public PaymentBuilder paymentDate(LocalDate localDate) {
        this.payment.setPaymentDate(localDate);
        return this;
    }

    public PaymentBuilder amountOfPayment(BigDecimal amountOfPayment) {
        this.payment.setAmountOfPayment(amountOfPayment);
        return this;
    }

    public PaymentBuilder amountOfMainDebtRepayment(BigDecimal amountOfMainDebtRepayment) {
        this.payment.setAmountOfMainDebtRepayment(amountOfMainDebtRepayment);
        return this;
    }

    public PaymentBuilder amountOfInterestRepayment(BigDecimal amountOfInterestRepayment) {
        this.payment.setAmountOfInterestRepayment(amountOfInterestRepayment);
        return this;
    }

    public Payment build() {
        return this.payment;
    }
}
