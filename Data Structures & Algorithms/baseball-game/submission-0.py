class Solution:
    def calPoints(self, operations: List[str]) -> int:
        if not operations:
            return 0
        
        st = []

        for ch in operations:
            if ch == "D":
                last_op = int(st[-1])
                st.append(str(last_op*2))
            elif ch == "+":
                first_op = int(st[-1])
                second_op = int(st[-2])
                st.append(str(first_op + second_op))
            elif ch == "C":
                st.pop()
            else:
                st.append(ch)

        
        res = []
        print(st)
        while st:
            res.append(int(st.pop()))
        
        return sum(res)

               
                    
        