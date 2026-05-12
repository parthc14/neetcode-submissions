class Solution:
    def isValid(self, s: str) -> bool:
        if s is None:
            return True
        
        st = []

        for ch in s:
            if ch in "([{":
                st.append(ch)
            else:
                if ch == "]":
                    if st and st[-1] == "[":
                        st.pop()
                    else:
                        return False
                elif ch == ")":
                    if st and st[-1] == "(":
                        st.pop()
                    else:
                        return False
                else:
                    if st and st[-1] == "{":
                        st.pop()
                    else:
                        return False
        
        return False if st else True