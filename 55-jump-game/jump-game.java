class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            // If we can't reach this index
            if (i > farthest) return false;

            // Update farthest we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If we can already reach last index
            if (farthest >= nums.length - 1) return true;
        }
        
        return true;
    }
}
