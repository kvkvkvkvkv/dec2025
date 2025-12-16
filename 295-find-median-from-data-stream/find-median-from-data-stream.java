class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());

        if(min.size()-max.size()>=2) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()) {
            return (double)(max.peek()+min.peek())/2;
        }
        return min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */