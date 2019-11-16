package paymentcalculation;

import paymentcalculation.CreditDetail;
import paymentcalculation.Payment;
import paymentcalculation.PaymentCalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AnnuityPaymentCalculation implements PaymentCalculation {
    @Override
    public List<Payment> calculatePayment(CreditDetail creditDetail) {
        List<Payment> result = new ArrayList<>();
        BigDecimal remaingMainDebt = creditDetail.getAmount();
        double monthInterestRate = creditDetail.getInterestRate() / 100.0 / 12.0;
        /**
         * Формула расчёта месячного платежа:
         * Сумма кредита * месячная ставка / (1 - (1 + месячная ставка)^(-срок кредита))
         * Вычисляется числитель и знаменатель формулы
         * В цикле вычисляется сумма выплаты по процентам,
         * остаток основного долга и месячная выплата по основному долгу соответственно
         */
        BigDecimal numerator = creditDetail.getAmount().multiply(new BigDecimal(monthInterestRate))
                .setScale(4, BigDecimal.ROUND_HALF_UP);
        BigDecimal denominator = new BigDecimal(1.0 - Math.pow((1.0 + monthInterestRate), -creditDetail.getTerm()))
                .setScale(8, BigDecimal.ROUND_HALF_UP);
        BigDecimal amountOfMonthRepayment = numerator.divide(denominator, RoundingMode.HALF_UP)
                .setScale(4, BigDecimal.ROUND_HALF_UP);

        LocalDate currentDate = creditDetail.getCreditExtraditionDate();
        for (int i = 0; i < creditDetail.getTerm(); i++) {
            currentDate = currentDate.plusMonths(1);

            BigDecimal amountOfInterestRepayment = remaingMainDebt.multiply(new BigDecimal(monthInterestRate))
                    .setScale(4, BigDecimal.ROUND_HALF_UP);;

            remaingMainDebt = remaingMainDebt.add(amountOfInterestRepayment).subtract(amountOfMonthRepayment);

            BigDecimal amountOfMainDebtRepayment = amountOfMonthRepayment.subtract(amountOfInterestRepayment)
                    .setScale(4, BigDecimal.ROUND_HALF_UP);;
            result.add(new Payment(currentDate, amountOfMonthRepayment, amountOfMainDebtRepayment, amountOfInterestRepayment));
        }
        return result;
    }
}
