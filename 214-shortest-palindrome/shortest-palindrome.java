public class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String newStr = s + "#" + rev;

        int[] lps = computeLPS(newStr);
        int prefixLen = lps[newStr.length() - 1];

        String suffix = s.substring(prefixLen);
        StringBuilder result = new StringBuilder(suffix).reverse().append(s);
        return result.toString();
    }

    // Helper to build LPS array
    private int[] computeLPS(String s) {
        int[] lps = new int[s.length()];
        int len = 0; // length of the previous longest prefix suffix

        for (int i = 1; i < s.length(); i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }

            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
            }
        }

        return lps;
    }
}