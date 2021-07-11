public class ConsecutiveSeriesMichaelDavid {
    public static void main(String[] args) {
        int start = 1;

        // Loop to check for a valid series
        // (Only need to check until 5000
        // (The sum will be greater than 10000 in cases that reach an upper bound above 5000)
        while (start < 5000)
        {
            // Check for any possible series in the given range (1 to 5000)
            int sum = 0;
            for (int n = start; n <= 5000; n++)
            {
                sum += n;

                // Check the sum with the goal of 10000
                if (sum == 10000) {
                    // If the sum is 10000, that means there is a valid series
                    // Print a condensed form of the series
                    System.out.printf("%d + %d + ... + %d + %d = 10000\n", start, start+1, n-1, n);
                    break;
                } else if (sum > 10000) {
                    // If the sum becomes greater than 10000, break out of the loop early
                    break;
                }
            }
            start++;
        }
    }
}
