import java.util.*;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store number and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement is already in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the current number and its index
            map.put(nums[i], i);
        }

        // Return empty if no solution found (though problem guarantees one)
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}