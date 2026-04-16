class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<n; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            bucket[i] = new ArrayList<>();
        }


        for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            bucket[value].add(key);
        }

        int[] res = new int[k];
        int resIdx = 0;
        
        for(int i=n; i>=1; i--) {
            if(bucket[i].size() == 0) continue;

            List<Integer> bucketElements = bucket[i];
            int bucketEndIdx = bucketElements.size()-1;
            while(resIdx < k && bucketEndIdx >= 0) {
                res[resIdx++] = bucketElements.get(bucketEndIdx);
                bucketEndIdx--;
            }

            if(resIdx >= k) break;
        }

        return res;
    }
}
