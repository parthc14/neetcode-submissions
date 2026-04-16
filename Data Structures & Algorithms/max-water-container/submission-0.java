class Solution {
    public int maxArea(int[] heights) {
        int maxArea = -1;

        int n = heights.length;

        for(int i=0; i<n; i++) {
            int area = 0;
            for(int j= i+1; j< n; j++) {
                area = Math.min(heights[i], heights[j]) * (j-i) ;

                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }
}
