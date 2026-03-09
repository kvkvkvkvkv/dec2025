class MyStack {
    Queue<Integer> q;
    Queue<Integer> q1;
    
    public MyStack() {
        q = new LinkedList<>();
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        while(!q.isEmpty()) {
            q1.add(q.poll());
        }
        while(!q1.isEmpty()) {
            q.add(q1.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
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