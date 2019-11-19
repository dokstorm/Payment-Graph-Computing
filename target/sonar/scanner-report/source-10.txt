package paymentcalculation;

public enum PaymentType {
    ANNUITY("Annuity"),
    DIFFERENCIAL("Differencial");

    private String paymentTypeName;
    PaymentType(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public static PaymentType paymentTypeFromInput(String input) {
        if (input.equals("Annuity")) {
            return PaymentType.ANNUITY;
        }
        else {
            if (input.equals("Differencial")) {
                return PaymentType.DIFFERENCIAL;
            }
            else throw new IllegalArgumentException(input + "is not a payment type.");
        }
    }
}