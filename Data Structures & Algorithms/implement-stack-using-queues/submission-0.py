class MyStack:

    def __init__(self):
        self.q_1 = deque([])
        self.q_2 = deque([])

    def push(self, x: int) -> None:
        if not self.q_1:
            self.q_1.append(x)
            return
        if not self.q_2:
            self.q_2.append(x)
            return
        if self.q_1 and self.q_2:
            if len(self.q_1) <= len(self.q_2):
                self.q_1.append(x)
                return
            self.q_2.append(x)
            return
    
    def pop(self) -> int:
        if self.q_1 and not self.q_2:
            return self.q_1.pop()
            
        if self.q_1 and self.q_2:
            if len(self.q_1) > len(self.q_2):
                return self.q_1.pop()
            return self.q_2.pop()
            

    def top(self) -> int:
        if self.q_1 and not self.q_2:
            return self.q_1[-1]
        if self.q_1 and self.q_2:
            if len(self.q_1) > len(self.q_2):
                return self.q_1[-1]
            return self.q_2[-1]

    def empty(self) -> bool:
        if self.q_1:
            return False
        return True


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()