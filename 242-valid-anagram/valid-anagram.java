import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Convert to char array and sort
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Compare sorted arrays
        return Arrays.equals(sArr, tArr);
    }
}