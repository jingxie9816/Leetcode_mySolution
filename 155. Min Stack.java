class MinStack {

    Deque<Integer> minStk;
    Deque<Integer> minVal;

    public MinStack() {
        minStk = new ArrayDeque<>();
        minVal = new ArrayDeque<>();
        minVal.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        minStk.push(val);
        int min = minVal.peek();
        if (val < min) {
            min = val;
        }
        minVal.push(min);
    }
    
    public void pop() {
        minStk.pop();
        minVal.pop();
    }
    
    public int top() {
        return minStk.peek();
    }
    
    public int getMin() {
        return minVal.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */