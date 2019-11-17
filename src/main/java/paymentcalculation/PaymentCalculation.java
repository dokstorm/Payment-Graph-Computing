package paymentcalculation;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentCalculation {
    List<Payment> calculatePayment(CreditDetail creditDetail);
}
