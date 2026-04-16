class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        for(int num: nums) {
            seen.add(num);
        }

        int longest = 0;
        int current  = 1;

        for(int num: nums) {
            int nextNo = num + 1;
            while(seen.contains(nextNo)) {
                nextNo = nextNo +1;
                current++;
            }

            longest = Math.max(longest, current);
            current = 1;
        }

        return longest;
    }
}
