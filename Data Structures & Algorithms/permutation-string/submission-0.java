class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n2; i++) {
            char[] s1CharArray = s1.toCharArray();
            Arrays.sort(s1CharArray);
            set.add(String.valueOf(s1CharArray));

            for(int j=i; j<=n2; j++) {
                String newString = s2.substring(i, j);
                char[] newStringCharArray = newString.toCharArray();
                Arrays.sort(newStringCharArray);
                String newValue = String.valueOf(newStringCharArray);
                if(set.contains(newValue)) {
                    return true;
                }
            }
        }

        return false;
    }
}
