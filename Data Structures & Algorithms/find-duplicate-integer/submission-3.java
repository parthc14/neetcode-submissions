class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        Set<Integer> seen = new HashSet();

        for(int num: nums) {
            if(seen.contains(num)) return num;
            seen.add(num);
        }

        return -1;
    }
}
