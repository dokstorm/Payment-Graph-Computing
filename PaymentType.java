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
        switch (input) {
            case "Annuity":
                return PaymentType.ANNUITY;
            case "Differencial":
                return PaymentType.DIFFERENCIAL;
        }
        throw new IllegalArgumentException(input + "is not a payment type.");
    }
}