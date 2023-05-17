class MyStack {
    Queue<Integer> originQueue;

    public MyStack() {
        originQueue = new ArrayDeque<>();

    }
    
    public void push(int x) {
        int s = originQueue.size();
        originQueue.offer(x);
        for (int i=0; i<s;i++){
            originQueue.offer(originQueue.poll());
        }
    }
    
    public int pop() {
        return originQueue.poll();
    }
    
    public int top() {
        return originQueue.peek();
    }
    
    public boolean empty() {
        return originQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */