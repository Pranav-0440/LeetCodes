class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading/trailing spaces and split by spaces (regex handles multiple spaces)
        String[] words = s.trim().split("\\s+");

        // Step 2: Reverse the array of words
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) { // Add space between words
                result.append(" ");
            }
        }

        // Step 3: Return the reversed string
        return result.toString();
    }
}
