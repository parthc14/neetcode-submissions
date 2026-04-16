class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int nse = -1;
        int pse = -1;
        int maxArea = 0;
        int area = 0;
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                int idx = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                nse = i;

                area = (nse - pse - 1) * heights[idx];
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int idx = st.pop();

            nse = n;
            pse = st.isEmpty() ? -1: st.peek(); 
            area = (nse - pse - 1) * heights[idx];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
