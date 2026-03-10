class StockSpanner {
    Stack<int[]> stack;
    int idx =0;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[0]<=price) {
            stack.pop();
        }
        int top = 0;
        if(stack.size()==0) {
            top = idx+1;
        } else {
            top = idx - stack.peek()[1];
        }
        stack.add(new int[]{price,idx});
        idx++;
        return top;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */