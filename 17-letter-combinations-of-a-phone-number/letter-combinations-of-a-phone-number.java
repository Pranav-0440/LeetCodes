import java.util.*;

public class Solution {
    // Map from digits to corresponding characters
    private static final Map<Character, String> digitToLetters = Map.of(
        '2', "abc", '3', "def", '4', "ghi",
        '5', "jkl", '6', "mno", '7', "pqrs",
        '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String possibleLetters = digitToLetters.get(digits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);  // Backtrack
        }
    }

    // Example run
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23"));  // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}