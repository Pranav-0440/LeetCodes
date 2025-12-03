class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Count of elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            // If current element is NOT equal to val, keep it
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move it to the front
                k++;
            }
        }

        return k;
    }
}