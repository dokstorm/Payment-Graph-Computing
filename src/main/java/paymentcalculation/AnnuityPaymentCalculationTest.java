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

public class AnnuityPaymentCalculationTest {

    @Test
    public void calculatePayment1() {
        CreditDetail creditDetail = new CreditDetail(12.0, 12, new BigDecimal(800000),
                PaymentType.ANNUITY, LocalDate.of(2014, Month.JANUARY, 15));

        AnnuityPaymentCalculation annuityPaymentCalculation = new AnnuityPaymentCalculation();

        BigDecimal[] expectedMainDebtRepayment = new BigDecimal[12];
        expectedMainDebtRepayment[0] = new BigDecimal(63079.03).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[1] = new BigDecimal(63709.82).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[2] = new BigDecimal(64346.92).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[3] = new BigDecimal(64990.39).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[4] = new BigDecimal(65640.29).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[5] = new BigDecimal(66296.69).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[6] = new BigDecimal(66959.66).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[7] = new BigDecimal(67629.26).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[8] = new BigDecimal(68305.55).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[9] = new BigDecimal(68988.61).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[10] = new BigDecimal(69678.49).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[11] = new BigDecimal(70375.28).setScale(2, RoundingMode.HALF_UP);

        BigDecimal[] expectedInterestRepayment = new BigDecimal[12];
        expectedInterestRepayment[0] = new BigDecimal(8000).setScale(2, RoundingMode.HALF_UP);;
        expectedInterestRepayment[1] = new BigDecimal(7369.21).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[2] = new BigDecimal(6732.11).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[3] = new BigDecimal(6088.64).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[4] = new BigDecimal(5438.74).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[5] = new BigDecimal(4782.34).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[6] = new BigDecimal(4119.37).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[7] = new BigDecimal(3449.77).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[8] = new BigDecimal(2773.48).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[9] = new BigDecimal(2090.42).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[10] = new BigDecimal(1400.54).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[11] = new BigDecimal(703.75).setScale(2, RoundingMode.HALF_UP);

        List<Payment> actual = annuityPaymentCalculation.calculatePayment(creditDetail);

        List<Payment> expected = new ArrayList<>();
        LocalDate currentDate = creditDetail.getCreditExtraditionDate();
        for (int i = 0; i < creditDetail.getTerm(); i++) {
            currentDate = currentDate.plusMonths(1);
            Payment payment = new Payment(currentDate, new BigDecimal(71079.03)
                    .setScale(2, RoundingMode.HALF_UP), expectedMainDebtRepayment[i], expectedInterestRepayment[i]);
            expected.add(payment);
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatePayment2() {
        CreditDetail creditDetail = new CreditDetail(15.5, 16, new BigDecimal(1200000),
                PaymentType.ANNUITY, LocalDate.of(1999, Month.SEPTEMBER, 28));

        AnnuityPaymentCalculation annuityPaymentCalculation = new AnnuityPaymentCalculation();

        BigDecimal[] expectedMainDebtRepayment = new BigDecimal[16];
        expectedMainDebtRepayment[0] = new BigDecimal(67998.39).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[1] = new BigDecimal(68876.70).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[2] = new BigDecimal(69766.36).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[3] = new BigDecimal(70667.51).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[4] = new BigDecimal(71580.30).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[5] = new BigDecimal(72504.88).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[6] = new BigDecimal(73441.40).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[7] = new BigDecimal(74390.02).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[8] = new BigDecimal(75350.89).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[9] = new BigDecimal(76324.17).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[10] = new BigDecimal(77310.02).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[11] = new BigDecimal(78308.61).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[12] = new BigDecimal(79320.10).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[13] = new BigDecimal(80344.65).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[14] = new BigDecimal(81382.43).setScale(2, RoundingMode.HALF_UP);
        expectedMainDebtRepayment[15] = new BigDecimal(82433.62).setScale(2, RoundingMode.HALF_UP);

        BigDecimal[] expectedInterestRepayment = new BigDecimal[16];
        expectedInterestRepayment[0] = new BigDecimal(15500.00).setScale(2, RoundingMode.HALF_UP);;
        expectedInterestRepayment[1] = new BigDecimal(14621.69).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[2] = new BigDecimal(13732.03).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[3] = new BigDecimal(12830.88).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[4] = new BigDecimal(11918.09).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[5] = new BigDecimal(10993.51).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[6] = new BigDecimal(10056.99).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[7] = new BigDecimal(9108.37).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[8] = new BigDecimal(8147.50).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[9] = new BigDecimal(7174.22).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[10] = new BigDecimal(6188.37).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[11] = new BigDecimal(5189.78).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[12] = new BigDecimal(4178.29).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[13] = new BigDecimal(3153.74).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[14] = new BigDecimal(2115.96).setScale(2, RoundingMode.HALF_UP);
        expectedInterestRepayment[15] = new BigDecimal(1064.77).setScale(2, RoundingMode.HALF_UP);

        List<Payment> actual = annuityPaymentCalculation.calculatePayment(creditDetail);

        List<Payment> expected = new ArrayList<>();
        LocalDate currentDate = creditDetail.getCreditExtraditionDate();
        for (int i = 0; i < creditDetail.getTerm(); i++) {
            currentDate = currentDate.plusMonths(1);
            Payment payment = new Payment(currentDate, new BigDecimal(83498.39).setScale(2, RoundingMode.HALF_UP), expectedMainDebtRepayment[i], expectedInterestRepayment[i]);
            expected.add(payment);
        }

        Assert.assertEquals(expected, actual);
    }
}