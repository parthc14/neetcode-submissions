class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int ans = -1;
        int max = findMax(piles, n);
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if(eatingRate(mid, piles) <= (long) h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;   
    }

    private long eatingRate(int currentRate, int[] piles) {
        long speed = 0;
        int n = piles.length;
        for(int i=0; i<n; i++) {
            speed += (long) (Math.ceil((double) piles[i] / currentRate));
        }

        return speed;
    }

    private int findMax(int[] arr, int n) {
        int max = arr[0];

        for(int i=1; i<n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}
