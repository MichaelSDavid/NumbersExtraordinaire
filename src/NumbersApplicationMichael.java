public class NumbersApplication {
    // Helper method to check if a number is prime
    public static boolean checkPrime(int n) {
        for (int i = 2; i < n/2; i++) {
            // Check relationship with divisors from range [2, n)
            // False if any quotients are whole numbers, else true
            if (((double) n / i) % 1 == 0) {
                return false;
            }
        }
        return true;
    }
    @SuppressWarnings("IfStatementWithIdenticalBranches")
    public static void main(String[] args) {
        // Prime numbers from 1 to 1 million
        // (Ctrl+C can quit early since this takes a while without arrays)
        System.out.println("Prime numbers from 1 to 1000000:\n");
        for (int n = 2; n < 1000000; n++) {
            if (checkPrime(n)) {
                if (n == 999983) {
                    // Formatting for last prime under 1 million (no extra comma)
                    System.out.print(n);
                    break;
                } else {
                    System.out.print(n + ", ");
                    break;
                }
            }
        }

        // Prime pairs (larger is 1 more than double the smaller) from 1 to 1 million
        // (Ctrl+C can quit early since this takes a while without arrays)
        System.out.println("\n\nPrime pairs from 1 to 1000000:\n");
        for (int n = 1; n < 1000000; n++) {
            if (checkPrime(n)) {
                // Check for valid pair (twice as much plus 1, less than 1 million)
                if (checkPrime(2*n+1) && (2*n+1) < 1000000) {
                    System.out.printf("(%d, %d)\n", n, 2*n+1);
                    break;
                } else if (2*n+1 > 1000000) {
                    // Break early if the predicted pair is already greater than 1 million
                    break;
                }
            }
        }

        // Perfect numbers up to 1000
        System.out.println("\nPerfect numbers up to 1000:\n");
        for (int n = 1; n <= 1000; n++) {
            int sum = 0;

            // Sum the divisors that are divided equally
            // (Have to be integers less than n)
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            // Check if the sum equals the given number
            if (sum == n) {
                if (n == 496) {
                    // Formatting for last perfect number under 1000 (no extra comma)
                    System.out.print(n);
                    break;
                } else {
                    System.out.print(n + ", ");
                    break;
                }
            }
        }

        // Abundant and deficient numbers up to 1000 (not including perfect)
        System.out.println("\nAbundant/deficient numbers up to 1000:\n");
        //noinspection ConstantConditions
        for (int n = 1; n <= 1000; n++) {
            int sum = 0;

            // Sum the divisors that are divided equally
            // (Have to be integers less than n)
            //noinspection ConstantConditions
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            // Check for abundancy/deficiency
            //noinspection ConstantConditions
            if (sum != n) {
                //noinspection ConstantConditions
                if (sum > n) {
                    System.out.println(n + " - abundant");
                    break;
                } else {
                    System.out.println(n + " - deficient");
                    break;
                }
            }
        }

        // 3 digit numbers that are equal to the sum of the cubes of their digits
        System.out.println("\n3 digit numbers equal to the sum of the cubes of their digits:\n");
        for (int n = 100; n < 1000; n++) {
            // Splits digits cubes and sums them up
            @SuppressWarnings("IntegerDivisionInFloatingPointContext")
            int sumOfCubes = (int) (Math.pow(n % 10, 3)
                    + Math.pow((((n % (100)) - (n % 10))/10), 3)
                    + Math.pow((((n % 1000) - (n % 100))/100), 3));

            // Check sum of cubes
            if (sumOfCubes == n) {
                if (n == 407) {
                    // Formatting for last 3 digit number under 1000 (no extra comma)
                    System.out.print(n);
                    break;
                } else {
                    System.out.print(n + ", ");
                    break;
                }
            }
        }

        // 4 digit numbers which the square of the sum of the first two digits and the last two digits equal the number
        System.out.println("\n\n4 digit numbers equal to the square of the sum of the first two digits and the last two digits:\n");
        for (int n = 1000; n < 10000; n++) {
            int squaredSum = (int) (Math.pow(Math.floor(n/100.0) + (n % 100), 2));

            if (squaredSum == n) {
                if (n == 9801) {
                    // Formatting for last 4 digit number under 10000 (no extra comma)
                    System.out.print(n);
                    break;
                } else {
                    System.out.print(n + ", ");
                    break;
                }
            }
        }
    }
}
