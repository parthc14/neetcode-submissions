class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap();

        // o(s)
        
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int val = map.get(c);
                map.put(c, val + 1);
            } else {
                map.put(c, 1);
            }
        }
        // o(t)
        for(int i =0; i< t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                int val = map.get(c);
                map.put(c, val - 1);
            } 
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() > 0){
                return false;
            }
        }

        return true;
    }
}
