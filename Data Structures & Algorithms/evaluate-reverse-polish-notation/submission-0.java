class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        
        for(String token: tokens) {
            if(!token.equals("+") && !token.equals("-") && !token.equals("/") && !token.equals("*")) {
                int num = Integer.parseInt(token);
                st.push(num);
            } else {
                int element1 = 0;
                int element2 = 0;
                switch(token) {
                    case "+": 
                        element2 = st.pop();
                        element1 = st.pop();
                        st.push(element1 + element2);
                        break;
                    case "-": 
                        element2 = st.pop();
                        element1 = st.pop();
                        st.push(element1 - element2);
                        break;
                    case "*" :
                        element2 = st.pop();
                        element1 = st.pop();
                        st.push(element1 * element2);
                        break;
                    default :
                        element2 = st.pop();
                        element1 = st.pop();
                        st.push(element1 / element2);
                        break;
                }
            
            } 
        }

        return st.pop();
    }
}
