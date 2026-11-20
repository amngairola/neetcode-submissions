class MedianFinder {

        PriorityQueue<Integer> min ;  // max on top
        PriorityQueue<Integer> max ; // min on top

    public MedianFinder() {
        min = new PriorityQueue<Integer>((a , b) -> b - a) ;
        max = new PriorityQueue<Integer>((a , b) -> a - b) ;

    }
    
    public void addNum(int num) {
        
        max.offer(num);

        min.offer(max.poll());


        if( min.size() > max.size() + 1 ){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        
        if(min.size() > max.size()) return min.peek();

        int n = min.peek();
        int m = max.peek();

        return ((double)  n + m ) / 2;
    }
}
