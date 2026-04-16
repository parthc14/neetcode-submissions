class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int n = str.length();
        int i = 0;
        
        while (i < n) {
            int len = 0;
            while (str.charAt(i) != '#') {
                len = len * 10 + (str.charAt(i) - '0');
                i++;
            }
            i++; 

            StringBuilder sb = new StringBuilder(len);
            for (int k = 0; k < len; k++) {
                sb.append(str.charAt(i + k));
            }
            res.add(sb.toString());
            i += len;
    }

        return res;
    }
}