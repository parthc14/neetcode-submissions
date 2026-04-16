class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<n; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        List<int[]> res = new ArrayList();


        for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            res.add(new int[]{entry.getKey(), entry.getValue()});
        }


        Collections.sort(res, (a, b) -> Integer.compare(b[1], a[1]));   

        int[] ans = new int[k];
        int resIdx = 0;
        
        for(int[] num : res){
            if(resIdx < k) {
                ans[resIdx++] = num[0];
            } else {
                break;
            }
        }

        return ans;
    }
}
