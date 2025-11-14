import java.util.*;

class Solution {

    // Compress function modifies chars[] in-place and returns new length
    public int compress(char[] chars) {
        int index = 0;  // position to write
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count consecutive characters
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            chars[index++] = currentChar;

            // If count > 1, write digits of the count
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }

    // Testing from main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();  // Example: aabbccc
        char[] chars = input.toCharArray();

        Solution sol = new Solution();
        int compressedLength = sol.compress(chars);

        System.out.print("Compressed Output: ");
        for (int i = 0; i < compressedLength; i++) {
            System.out.print(chars[i]);
        }
        System.out.println("\nLength: " + compressedLength);
    }
}