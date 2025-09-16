class Solution {
    public int jump(int[] nums) {
        int jumps = 0, end = 0, farthest = 0;
        
        // We don’t need to process the last index, just reach it
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            // When we reach the end of current jump range
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
