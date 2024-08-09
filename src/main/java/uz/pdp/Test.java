package uz.pdp;

public class Test {
    public static void main(String[] args) {
        System.out.println(myPow(2,-2147483648));
    }
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            x = 1 / x;
            // Используем long, чтобы избежать переполнения
            n = -n;
        }

        return powHelper(x, n);
    }

    private static double powHelper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = powHelper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
