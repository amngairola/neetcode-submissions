class MedianFinder {

    PriorityQueue<Integer> max ; // max willbe on top : if odd len return min top
     PriorityQueue<Integer> min ; // min will be on top
    
    public MedianFinder() {
            min = new PriorityQueue<>((a , b) ->  Integer.compare(b , a));
            max = new PriorityQueue<>((a , b) -> Integer.compare(a , b));
    }
    
    public void addNum(int num) {
        
        max.offer(num);

        min.offer(max.poll());
        
        
        
        if(min.size()  > max.size() + 1) max.offer(min.poll());
       
    }
    
    public double findMedian() {
        int n = min.size();
        int m = max.size();

        if( n > m ) return min.peek();

        int a = min.peek();
        int b = max.peek();

         return ((double) min.peek() + max.peek()) / 2;
    }
}
