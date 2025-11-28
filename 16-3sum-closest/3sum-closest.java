import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];  // Start with the first triplet

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                // Update closest if this sum is closer to target
                if (Math.abs(currSum - target) < Math.abs(closest - target)) {
                    closest = currSum;
                }

                // Move pointers based on comparison
                if (currSum < target) {
                    left++;
                } else if (currSum > target) {
                    right--;
                } else {
                    return target;  // Exact match
                }
            }
        }

        return closest;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));  // Output: 2
    }
}