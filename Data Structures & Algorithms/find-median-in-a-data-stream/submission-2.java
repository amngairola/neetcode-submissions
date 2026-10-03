class MedianFinder {
    // odd = middle 
    // even = mean ->  m[i]+m[i-1]/2


    PriorityQueue<Integer> maxi;
    PriorityQueue<Integer> mini;
    public MedianFinder() {
         maxi = new PriorityQueue <>((a ,b) ->  Integer.compare(b ,a));
         mini = new PriorityQueue <>((a ,b) -> Integer.compare(a ,b));
    }
    
    public void addNum(int num) {
        maxi.add(num);

        
        mini.offer(maxi.poll());
       


        if( maxi.size()< mini.size()){
            
            maxi.offer(mini.poll());
        }
    }
    
    public double findMedian() {

       int n = maxi.size();
       int m = mini.size(); 

        if(n == m){
           
           return (maxi.peek() + mini.peek()) / 2.0;
        }
      
       return maxi.peek();
    }
}
