class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;  // Target found
            } else if (nums[mid] < target) {
                start = mid + 1;  // Search right half
            } else {
                end = mid - 1;  // Search left half
            }
        }

        return start;  // Target not found, return insert position
    }
}