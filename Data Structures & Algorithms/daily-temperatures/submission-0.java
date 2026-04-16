class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            int maxTempSoFar = 0;

            for(int j = i+1; j<n; j++) {
                if(temperatures[j] > temperatures[i]) {
                    maxTempSoFar = (j - i);
                    break;
                }
            }
            res[i] = maxTempSoFar;
        }

        return res;
    }
}
