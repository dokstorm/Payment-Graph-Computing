package paymentcalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public final class TestUtil {
    private TestUtil() {
        throw new AssertionError();
    }

    public static BigDecimal[] bigDecimalArrayFromDoubles(double... doubleArray) {
        return Arrays.stream(doubleArray)
                .mapToObj(val -> BigDecimal.valueOf(val).setScale(2, RoundingMode.HALF_UP))
                .toArray(BigDecimal[]::new);
    }
}
