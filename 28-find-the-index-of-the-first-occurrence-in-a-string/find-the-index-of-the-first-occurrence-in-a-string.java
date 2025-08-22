class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Slide window of size 'needle' over 'haystack'
        for (int i = 0; i <= n - m; i++) {
            // Check if substring matches
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        // If not found
        return -1;
    }
}