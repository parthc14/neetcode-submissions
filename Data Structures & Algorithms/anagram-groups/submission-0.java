class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        if(strs == null || strs.length == 0) return res;

        HashMap<String, List<String>> countMap = new HashMap<>();

        for(String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            if(!countMap.containsKey(sortedString)) {
                countMap.put(sortedString, new ArrayList<String>());
            }
            List<String> list = countMap.get(sortedString);
            list.add(str);
            countMap.put(sortedString, list);
        }

        for(Map.Entry<String, List<String>> entries: countMap.entrySet()) {
            res.add(entries.getValue());
        }

        return res;
    }
}
