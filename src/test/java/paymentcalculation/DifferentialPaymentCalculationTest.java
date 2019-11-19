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

public class DifferentialPaymentCalculationTest {

    @Test
    public void calculatePayment() {
        CreditDetail creditDetail = new CreditDetail(8.3, 14, BigDecimal.valueOf(1150000.00)
                .setScale(2, RoundingMode.HALF_UP), PaymentType.DIFFERENCIAL,
                LocalDate.of(2014, Month.JANUARY, 15));

        DifferentialPaymentCalculation differentialPaymentCalculation = new DifferentialPaymentCalculation();

        List<Payment> expected = new PaymentListBuilder()
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.FEBRUARY, 15))
                        .amountOfPayment(BigDecimal.valueOf(90097.03)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(7954.17)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.MARCH, 15))
                        .amountOfPayment(BigDecimal.valueOf(89528.87)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(7386.01)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.APRIL, 15))
                        .amountOfPayment(BigDecimal.valueOf(88960.72)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(6817.86)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.MAY, 15))
                        .amountOfPayment(BigDecimal.valueOf(88392.56)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(6249.70).setScale(2, RoundingMode.HALF_UP)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.JUNE, 15))
                        .amountOfPayment(BigDecimal.valueOf(87824.41)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(5681.55)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.JULY, 15))
                        .amountOfPayment(BigDecimal.valueOf(87256.25)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(5113.39)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.AUGUST, 15))
                        .amountOfPayment(BigDecimal.valueOf(86688.10).setScale(2, RoundingMode.HALF_UP))
                        .amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(4545.24)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.SEPTEMBER, 15))
                        .amountOfPayment(BigDecimal.valueOf(86119.94)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(3977.08)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.OCTOBER, 15))
                        .amountOfPayment(BigDecimal.valueOf(85551.79)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(3408.93)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.NOVEMBER, 15))
                        .amountOfPayment(BigDecimal.valueOf(84983.63)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(2840.77)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2014, Month.DECEMBER, 15))
                        .amountOfPayment(BigDecimal.valueOf(84415.48)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(2272.62)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2015, Month.JANUARY, 15))
                        .amountOfPayment(BigDecimal.valueOf(83847.32)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(1704.46)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2015, Month.FEBRUARY, 15))
                        .amountOfPayment(BigDecimal.valueOf(83279.17)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(1136.31)).build())
                .addPayment(new PaymentBuilder().paymentDate(LocalDate.of(2015, Month.MARCH, 15))
                        .amountOfPayment(BigDecimal.valueOf(82711.01)).amountOfMainDebtRepayment(BigDecimal.valueOf(82142.86))
                        .amountOfInterestRepayment(BigDecimal.valueOf(568.15)).build()).build();

        List<Payment> actual = differentialPaymentCalculation.calculatePayment(creditDetail);

        Assert.assertEquals(expected, actual);
    }
}