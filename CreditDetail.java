import java.math.BigDecimal;

public class CreditDetail {

    private double interestRate;
    private int term;
    private BigDecimal amount;
    private PaymentType paymentType;

    public CreditDetail(double interestRate, int term, BigDecimal amount, PaymentType paymentType) {
        this.interestRate = interestRate;
        this.term = term;
        this.amount = amount;
        this.paymentType = paymentType;
    }

}


