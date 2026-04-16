class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{') st.push(ch);
            else {
                if(ch == ')') {
                    if(!st.isEmpty() && st.peek() == '(') st.pop();
                    else return false;
                    
                } else if(ch == ']') {
                    if(!st.isEmpty() && st.peek() == '[') st.pop();
                    else return false;
                } else {
                    if(!st.isEmpty() && st.peek() == '{') st.pop();
                    else return false;
                }
            }
        }

        return st.empty() ? true : false;
    }
}
