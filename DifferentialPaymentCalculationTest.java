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
    public void calculatePayment1() {
        CreditDetail creditDetail = new CreditDetail(12.0, 12, new BigDecimal("1000000.00"),
                PaymentType.DIFFERENCIAL, LocalDate.of(2014, Month.JANUARY, 15));

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

    @Test
    public void calculatePayment2() {
        CreditDetail creditDetail = new CreditDetail(8.3, 14, new BigDecimal("1150000.00"),
                PaymentType.DIFFERENCIAL, LocalDate.of(2014, Month.JANUARY, 15));

        DifferentialPaymentCalculation differentialPaymentCalculation = new DifferentialPaymentCalculation();

        BigDecimal[] expectedAmountOfPayment = new BigDecimal[14];
        expectedAmountOfPayment[0] = new BigDecimal(90097.03).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[1] = new BigDecimal(89528.87).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[2] = new BigDecimal(88960.72).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[3] = new BigDecimal(88392.56).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[4] = new BigDecimal(87824.41).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[5] = new BigDecimal(87256.25).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[6] = new BigDecimal(86688.10).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[7] = new BigDecimal(86119.94).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[8] = new BigDecimal(85551.79).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[9] = new BigDecimal(84983.63).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[10] = new BigDecimal(84415.48).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[11] = new BigDecimal(83847.32).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[12] = new BigDecimal(83279.17).setScale(2, RoundingMode.HALF_UP);
        expectedAmountOfPayment[13] = new BigDecimal(82711.01).setScale(2, RoundingMode.HALF_UP);

        BigDecimal[] expectedInterestRepayment = new BigDecimal[14];
        expectedInterestRepayment[0] = new BigDecimal(7954.17).setScale(2, RoundingMode.HALF_UP);;
        expectedInterestRepayment[1] = new BigDecimal(7386.01).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[2] = new BigDecimal(6817.86).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[3] = new BigDecimal(6249.70).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[4] = new BigDecimal(5681.55).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[5] = new BigDecimal(5113.39).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[6] = new BigDecimal(4545.24).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[7] = new BigDecimal(3977.08).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[8] = new BigDecimal(3408.93).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[9] = new BigDecimal(2840.77).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[10] = new BigDecimal(2272.62).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[11] = new BigDecimal(1704.46).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[12] = new BigDecimal(1136.31).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[13] = new BigDecimal(568.15).setScale(2, RoundingMode.HALF_UP);

        List<Payment> actual = differentialPaymentCalculation.calculatePayment(creditDetail);

        List<Payment> expected = new ArrayList<>();
        LocalDate currentDate = creditDetail.getCreditExtraditionDate();
        for (int i = 0; i < creditDetail.getTerm(); i++) {
            currentDate = currentDate.plusMonths(1);
            Payment payment = new Payment(currentDate, expectedAmountOfPayment[i], new BigDecimal(82142.86)
                    .setScale(2, RoundingMode.HALF_UP), expectedInterestRepayment[i]);
            expected.add(payment);
        }

        Assert.assertEquals(expected, actual);
    }

}