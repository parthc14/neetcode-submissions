class TimeMap {
    Map<String, TreeMap<Integer, String>> mpp;
    public TimeMap() {
        mpp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mpp.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp, value);

    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> innerMap = mpp.get(key);
        if(innerMap == null) return "";

        Map.Entry<Integer, String> entry = innerMap.floorEntry(timestamp);
        if(entry == null) return "";
        return entry.getValue();
    }
}
