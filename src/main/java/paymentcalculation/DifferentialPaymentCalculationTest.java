package main.java.paymentcalculation;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DifferentialPaymentCalculationTest {

    @Test
    public void calculatePayment() {
        CreditDetail creditDetail = new CreditDetail(12.0, 12, new BigDecimal("1000000.00"),
                PaymentType.ANNUITY, LocalDate.of(2014, Month.JANUARY, 15));

        DifferentialPaymentCalculation differentialPaymentCalculation = new DifferentialPaymentCalculation();

        BigDecimal[] expectedAmountOfPayment = new BigDecimal[12];
        expectedAmountOfPayment[0] = new BigDecimal(93333.33).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[1] = new BigDecimal(92500.00).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[2] = new BigDecimal(91666.66).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[3] = new BigDecimal(90833.33).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[4] = new BigDecimal(90000.00).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[5] = new BigDecimal(89166.66).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[6] = new BigDecimal(88333.33).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[7] = new BigDecimal(87500.00).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[8] = new BigDecimal(86666.66).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[9] = new BigDecimal(85833.33).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[10] = new BigDecimal(85000.00).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[11] = new BigDecimal(84166.66).setScale(2, RoundingMode.HALF_UP);

        BigDecimal[] expectedInterestRepayment = new BigDecimal[12];
        expectedInterestRepayment[0] = new BigDecimal(10000).setScale(2, RoundingMode.HALF_UP);;
        expectedInterestRepayment[1] = new BigDecimal(9166.67).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[2] = new BigDecimal(8333.33).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[3] = new BigDecimal(7500.00).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[4] = new BigDecimal(6666.67).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[5] = new BigDecimal(5833.33).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[6] = new BigDecimal(5000.00).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[7] = new BigDecimal(4166.67).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[8] = new BigDecimal(3333.33).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[9] = new BigDecimal(2500.00).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[10] = new BigDecimal(1666.67).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[11] = new BigDecimal(833.33).setScale(2, RoundingMode.HALF_UP);

        List<Payment> actual = differentialPaymentCalculation.calculatePayment(creditDetail);

        List<Payment> expected = new ArrayList<>();
        LocalDate currentDate = creditDetail.getCreditExtraditionDate();
        for (int i = 0; i < creditDetail.getTerm(); i++) {
            currentDate = currentDate.plusMonths(1);
            Payment payment = new Payment(currentDate, expectedAmountOfPayment[i], new BigDecimal(83333.33)
                    .setScale(2, RoundingMode.HALF_UP), expectedInterestRepayment[i]);
            expected.add(payment);
        }

        Assert.assertEquals(expected, actual);
    }
}