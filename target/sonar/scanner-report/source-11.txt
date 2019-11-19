package paymentcalculation;

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
        CreditDetail creditDetail = new CreditDetail(12.0, 12, BigDecimal.valueOf(800000.00)
                .setScale(2, RoundingMode.HALF_UP),
                PaymentType.ANNUITY, LocalDate.of(2014, Month.JANUARY, 15));

        AnnuityPaymentCalculation annuityPaymentCalculation = new AnnuityPaymentCalculation();

        List<Payment> expected = new PaymentListBuilder()
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.FEBRUARY, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(63079.03))
                        .amountOfInterestRepayment(BigDecimal.valueOf(8000.00).setScale(2, RoundingMode.HALF_UP)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.MARCH, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(63709.82))
                        .amountOfInterestRepayment(BigDecimal.valueOf(7369.21)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.APRIL, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(64346.92))
                        .amountOfInterestRepayment(BigDecimal.valueOf(6732.11)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.MAY, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(64990.39))
                        .amountOfInterestRepayment(BigDecimal.valueOf(6088.64)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.JUNE, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(65640.29))
                        .amountOfInterestRepayment(BigDecimal.valueOf(5438.74)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.JULY, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(66296.69))
                        .amountOfInterestRepayment(BigDecimal.valueOf(4782.34)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.AUGUST, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(66959.66))
                        .amountOfInterestRepayment(BigDecimal.valueOf(4119.37)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.SEPTEMBER, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(67629.26))
                        .amountOfInterestRepayment(BigDecimal.valueOf(3449.77)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.OCTOBER, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(68305.55))
                        .amountOfInterestRepayment(BigDecimal.valueOf(2773.48)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.NOVEMBER, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(68988.61))
                        .amountOfInterestRepayment(BigDecimal.valueOf(2090.42)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.DECEMBER, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(69678.49))
                        .amountOfInterestRepayment(BigDecimal.valueOf(1400.54)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2015, Month.JANUARY, 15))
                        .amountOfPayment(BigDecimal.valueOf(71079.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(70375.28))
                        .amountOfInterestRepayment(BigDecimal.valueOf(703.75)).build()).build();

        List<Payment> actual = annuityPaymentCalculation.calculatePayment(creditDetail);

        Assert.assertEquals(expected, actual);
    }
}