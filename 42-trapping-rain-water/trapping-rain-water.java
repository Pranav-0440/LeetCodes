import java.util.Scanner;
class Solution {
    public static int trap(int[] height) {
        int n = height.length;
        // leftMax
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for(int i=1; i<n; i++){
            leftmax[i]=Math.max(height[i], leftmax[i-1]);
        }
        //rightMax
        int rightmax[] = new int[n];
        rightmax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightmax[i]=Math.max(height[i], rightmax[i+1]);
        }
        //Loop
        int trappedWater=0;
        for(int i=0; i<n; i++){
            //waterlevel
            int waterLevel=Math.min(leftmax[i],rightmax[i]);
            //trappedWater
            trappedWater+=waterLevel-height[i];
        }
        return trappedWater;
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height[] = new int[n];
        for(int i=0; i<n; i++){
            height[i]=sc.nextInt();
        }
        trap(height);
    }
}