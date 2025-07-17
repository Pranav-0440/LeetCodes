import java.util.*;

public class Solution {

    public boolean isPalindrome(String s) {
        // Step 1: Convert to lowercase and remove non-alphanumeric characters
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Step 2: Use two-pointer technique to check palindrome
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(input));
    }
}
