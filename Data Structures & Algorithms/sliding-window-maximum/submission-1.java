class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ansIdx = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            // Check if current window is maintained
            if(!dq.isEmpty() && dq.peekFirst() <= (i-k)) {
                dq.pollFirst();
            }            

            // Check if monotonically decreasing order is maintained
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);    
            if(i >= k-1) {
                ans[ansIdx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
