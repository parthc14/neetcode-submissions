class MinStack {
    long minValue;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
        minValue = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long value = val;
        if(stack.isEmpty()) {
            minValue = value;
            stack.push(value);
            return;
        }

        long stackTop = stack.peek();
        if(value < minValue) {
            long newValue = 2 * value - minValue;
            stack.push(newValue);
            minValue = value;
            return;
        }
        stack.push(value);
    }
    
    public void pop() {
        long stackTopElement = stack.peek();
        if(stackTopElement < minValue) {
            minValue = 2 * minValue - stackTopElement; 
        }
        stack.pop();
    }
    
    public int top() {
        long stackTop = stack.peek();
        if(minValue > stackTop) return (int) minValue;
        return (int) stackTop;
    }
    
    public int getMin() {
        return (int) minValue;
    }
}
