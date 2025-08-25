class Solution {
    public int divide(int dividend, int divisor) {
        // Special case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow case
        }

        // Convert both dividend and divisor to long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;

        // Bit shifting to find how many times the divisor fits into dividend
        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;

            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            result += multiple;
        }

        // Adjust sign
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }
}