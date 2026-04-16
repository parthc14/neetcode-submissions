class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;

        int n1 = s1.length();
        int n2 = s2.length();

        int[] s1Map = new int[26];
        int count = 0;

        for(int i=0; i<n1; i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }

        for(int i=0; i<n2; i++) {
            int[] s2Map = new int[26];
            int currCount = 0;
            for(int j=i; j<n2; j++) {
                
                int currChar = s2.charAt(j) - 'a';

                s2Map[currChar]++;
                if(s1Map[currChar] < s2Map[currChar]) {
                    break;
                } 

                
                currCount++;
                

                if(currCount == n1) {
                    return true;
                }
            }
        }

        return false;

    }
}
