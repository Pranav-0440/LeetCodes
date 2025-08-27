class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        // Initialize
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];
        
        // Traverse
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            
            // If negative, swap because min can become max
            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            
            // Update max/min ending at i
            maxProd = Math.max(curr, curr * maxProd);
            minProd = Math.min(curr, curr * minProd);
            
            // Update global max
            ans = Math.max(ans, maxProd);
        }
        
        return ans;
    }
}
