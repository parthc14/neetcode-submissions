class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        //     i 
        // 4 5 6  target = 10
        // {4: 0, 5: 1}
        for (int i=0; i< nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{ map.get(target - nums[i]),i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{0,0};
    }
}
