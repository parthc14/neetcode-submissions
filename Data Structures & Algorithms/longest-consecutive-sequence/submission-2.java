class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        for(int num: nums) {
            seen.add(num);
        }

        int longest = 0;

        for(int num: nums) {
            if(!seen.contains(num-1)) {
                int length = 1;
                while(seen.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
