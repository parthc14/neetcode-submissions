class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        if(strs == null || strs.length == 0) return res;

        HashMap<String, List<String>> countMap = new HashMap<>();

        for(String str : strs) {
            String sortedString = getSortedString(str);
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

    private String getSortedString(String s) {
        StringBuilder sb = new StringBuilder();

        int[] countMap = new int[26];

        for(int i=0; i<s.length(); i++) {
            countMap[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++) {
            sb.append('#').append(countMap[i]);
        }

        return sb.toString();
    }
}
