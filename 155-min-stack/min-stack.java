class MinStack {

    Node head;
    Node tail;
    public MinStack() {
        head = new Node(-1, -1);
        tail = head;
    }
    
    public void push(int val) {
        Node newNode = null;
        if(tail == head) {
            newNode = new Node(val, val);
        } else {
            newNode = new Node(val, Math.min(val, tail.min));
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    
    public void pop() {
        Node newNode = tail.prev;
        tail = null;
        tail = newNode;
    }
    
    public int top() {
        return tail.val;
    }
    
    public int getMin() {
        return tail.min;
    }
}

class Node {
    Node next;
    Node prev;
    int val;
    int min;

    Node(int val, int min) {
        this.val = val;
        this.min = min;
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