package paymentcalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DifferentialPaymentCalculation implements PaymentCalculation {
    @Override
    public List<Payment> calculatePayment(CreditDetail creditDetail) {
        List<Payment> result = new ArrayList<>();
        BigDecimal remaingMainDebt = creditDetail.getAmount();
        BigDecimal monthMainDebtRepayment = creditDetail.getAmount().divide(BigDecimal.valueOf(creditDetail.getTerm())
                .setScale(8, RoundingMode.HALF_UP), RoundingMode.HALF_UP);

        LocalDate currentDate = creditDetail.getCreditExtraditionDate();
        double monthInterestRate = creditDetail.getInterestRate() / 100.0 / 12.0;

        for (int i = 0; i < creditDetail.getTerm(); i++) {
            currentDate = currentDate.plusMonths(1);

            BigDecimal amountOfInterestRepayment = remaingMainDebt.multiply(BigDecimal.valueOf(monthInterestRate))
                    .setScale(8, BigDecimal.ROUND_HALF_UP);

            remaingMainDebt = remaingMainDebt.subtract(monthMainDebtRepayment);
            result.add(new Payment(currentDate, monthMainDebtRepayment.add(amountOfInterestRepayment)
                    .setScale(2, RoundingMode.HALF_UP), monthMainDebtRepayment
                    .setScale(2, RoundingMode.HALF_UP), amountOfInterestRepayment
                    .setScale(2, RoundingMode.HALF_UP)));
        }
        return result;
    }
}
