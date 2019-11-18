package main.java.paymentcalculation;

import java.util.List;

public interface PaymentCalculation {
    List<Payment> calculatePayment(CreditDetail creditDetail);
}
