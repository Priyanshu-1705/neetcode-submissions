class MinStack {
    Stack<Long> stack;
    long minVal;

    public MinStack() {
        stack = new Stack<>();
        minVal = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push((long) val);
            minVal = val;
            return;
        }

        if(val < minVal) {
            stack.push(2L * val - minVal);
            minVal = val;
        } else {
            stack.push((long) val);
        }
    }
    
    public void pop() {
        if(stack.peek() < minVal) {
            minVal = 2 * minVal - stack.peek();
        }

        stack.pop();
    }
    
    public int top() {
        if(stack.peek() < minVal) {
            return (int) minVal;
        }

        return stack.peek().intValue();
    }
    
    public int getMin() {
        return (int) minVal;
    }
}