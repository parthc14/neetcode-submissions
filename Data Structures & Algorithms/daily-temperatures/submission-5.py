class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if not temperatures:
            return []
        
        st = []
        res = [0] * len(temperatures)
        for i in range(len(temperatures)-1, -1, -1):
            while st and temperatures[i] >= temperatures[st[-1]]:
                st.pop()
            
            res[i] = 0 if not st else st[-1] - i
            st.append(i)
        
        return res
