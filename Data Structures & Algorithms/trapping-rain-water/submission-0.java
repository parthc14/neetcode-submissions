class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        int leftMaxSoFar = leftMax[0];
        int rightMaxSoFar = rightMax[n-1];

        for(int i=1; i<n; i++) {
            if(leftMaxSoFar < height[i]) {
                leftMaxSoFar = height[i];
            }

            leftMax[i] = leftMaxSoFar;
        }

        for(int i=n-2; i>=0; i--) {
            if(rightMaxSoFar < height[i]) {
                rightMaxSoFar = height[i];
            }

            rightMax[i] = rightMaxSoFar;
        }

        int maxArea = 0;
        for(int i=0; i<n; i++) {
            if(height[i] < leftMax[i] && height[i] < rightMax[i]) {
                maxArea += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }

        return maxArea;
    }
}
