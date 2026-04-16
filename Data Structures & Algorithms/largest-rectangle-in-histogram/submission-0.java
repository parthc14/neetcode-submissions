class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] pse = findPse(heights, n);
        int[] nse = findNse(heights, n);

        int maxArea = 0;
        int area = 0;
        for(int i=0; i<n; i++) {
            area = (nse[i] - pse[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
    
    public int[] findPse(int[] heights, int n) {
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }

    public int[] findNse(int[] heights, int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

}
