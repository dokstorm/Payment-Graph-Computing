import java.math.BigDecimal;

public interface PaymentCalculation {
    BigDecimal calculatePayment(int currentMonth, CreditDetail creditDetail);
}
