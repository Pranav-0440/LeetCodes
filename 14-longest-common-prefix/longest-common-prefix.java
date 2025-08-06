public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start by assuming the first string is the prefix
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string doesn't start with the prefix, shorten the prefix
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix is empty, return ""
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}