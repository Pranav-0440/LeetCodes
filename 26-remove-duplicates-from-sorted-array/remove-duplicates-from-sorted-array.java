class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // `i` is the slow pointer - tracks position of the last unique element
        int i = 0;

        // `j` is the fast pointer - scans the array
        for (int j = 1; j < nums.length; j++) {
            // When a new unique element is found
            if (nums[j] != nums[i]) {
                i++;              // move slow pointer forward
                nums[i] = nums[j]; // update unique value in-place
            }
        }

        // `i + 1` is the number of unique elements
        return i + 1;
    }
}