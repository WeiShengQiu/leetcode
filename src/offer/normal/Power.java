package offer.normal;

public class Power {
    public static double power(double base, int exponent) {
        if (exponent < 0) {
            exponent = exponent * -1;
            base = 1 / base;
        }
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result = result * base;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2.0000d, -2));
    }
}
