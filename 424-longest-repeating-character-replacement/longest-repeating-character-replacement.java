class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];  // frequency of characters in window
        int left = 0, maxCount = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // If window is invalid, shrink from left
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update result with max window size
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
