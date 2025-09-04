class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n; // already valid

        int k = 2; // pointer where the next valid element should go

        for (int i = 2; i < n; i++) {
            // Compare current element with nums[k-2]
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
