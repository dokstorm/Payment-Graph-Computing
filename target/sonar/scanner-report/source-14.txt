package paymentcalculation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentListBuilder {

    private List<Payment> payments = new ArrayList<Payment>();

    public PaymentListBuilder addPayment(Payment payment){
        payments.add(payment);
        return this;
    }

    public List<Payment> build() {
       return payments;
    }

}
