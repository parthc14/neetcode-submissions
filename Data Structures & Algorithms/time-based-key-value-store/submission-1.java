class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {
    Map<String, List<Pair>> mpp;
    public TimeMap() {
        mpp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mpp.containsKey(key)) {
            mpp.put(key, new ArrayList<Pair>());
        }
        mpp.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(mpp.get(key) == null) return "";

        List<Pair> timestampList = mpp.get(key);
        int idx = findSearchPosition(timestamp, timestampList);

        return idx == -1 ? "" : timestampList.get(idx).value;
    }

    private int findSearchPosition(int target, List<Pair> arr) {
        int n = arr.size();

        int low = 0;
        int high = n-1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            int elem = arr.get(mid).timestamp;
            if(elem <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
