class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int i=0; i<n; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        
        for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] ans = new int[k];
        int resIdx = 0;
        
        while(!pq.isEmpty() && resIdx < k) {
            ans[resIdx++] = pq.poll()[0];
        }

        return ans;
    }
}
