public class Factorial {

    public static long pureRecursive(int n) {
        long fact;
        // check for negative and zero numbers
        if(n <= 0) {
            throw new IllegalArgumentException();
        }

        // base case
        if(n == 1) {
            return 1;

        } else {
            // factorial formula
            fact = n * pureRecursive(n-1);
            return fact;
        }
    }

    public static long tailRecursive(int n) {
        // should only return tail method
        return tail(n);
    }

    private static long tail(int n) {
        // check for negative and zero numbers
        if(n <= 0) {
            throw new IllegalArgumentException();
        }

        if(n == 1) {
            return 1;

        } else {
            return n * tail(n-1);
        }
    }

    public static long iterative(int n) {
        long fact = 1;
        // check for negative and zero numbers
        if(n <= 0) {
            throw new IllegalArgumentException();
        }

        // factorial using an iterative method
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

}

