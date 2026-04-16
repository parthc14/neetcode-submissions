class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = n-1;

        int maxArea = 0;
        while(left <= right) {
            if(leftMax <= rightMax) {
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    maxArea += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];   
                } else {
                    maxArea += rightMax - height[right];
                }
                right--;
            }
        }

        return maxArea;
    }
}
