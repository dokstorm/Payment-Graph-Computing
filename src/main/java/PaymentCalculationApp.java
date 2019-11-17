import paymentcalculation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentCalculationApp {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        CreditDetail creditDetail = new CreditDetail(12.0, 24, new BigDecimal(800000), PaymentType.ANNUITY, localDate);
        PaymentCalculation annuityPaymentCalculation = new AnnuityPaymentCalculation();
        System.out.println("Аннуитетный платёж: ");
        for (Payment x : annuityPaymentCalculation.calculatePayment(creditDetail)) {
            System.out.println(x);
        }

        System.out.println("Дифференцированный платёж: ");

        PaymentCalculation differentialPaymentCalculation = new DifferentialPaymentCalculation();
        for (Payment x : differentialPaymentCalculation.calculatePayment(creditDetail)) {
            System.out.println(x);
        }


    }
}
