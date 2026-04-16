class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if s[i] == '(' or s[i] == '[' or s[i] == '{': 
                stack.append(s[i])
            else:
                if s[i] == ')':
                    if len(stack) > 0 and stack[-1] == '(': 
                        stack.pop()
                    else:
                        return False
                elif s[i] == ']':
                    if len(stack) > 0 and stack[-1] == '[': 
                        stack.pop()
                    else:
                        return False
                else: 
                    if len(stack) > 0 and stack[-1] == '{': 
                        stack.pop()
                    else:
                        return False
        return False if len(stack) > 0 else True
        
        
