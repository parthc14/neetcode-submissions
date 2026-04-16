class Solution {
    public int maxArea(int[] heights) {
        int maxArea = -1;

        int n = heights.length;
        int area = 0;
        int left = 0;
        int right = n-1;

        while (left < right) {
            area = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

            
        }

        return maxArea;
    }
}
