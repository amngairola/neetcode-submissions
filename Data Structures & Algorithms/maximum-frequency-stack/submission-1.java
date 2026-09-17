class Pair{

    int val ;
    int freq ;
    int indx;

    Pair(int val , int freq , int indx){
        this.val = val;
        this.freq = freq ;
        this.indx = indx;
    }
}

class FreqStack {

    HashMap<Integer , Integer> mp;
      int indx;
    PriorityQueue<Pair> pq;

    public FreqStack() {
        mp = new HashMap<>();
        pq = new PriorityQueue<Pair>((a ,b)->{ 
            if(a.freq == b.freq){
                return  b.indx - a.indx;
             } 
           return b.freq - a.freq;
           }
        );
        indx = 0;
    }
    
    public void push(int val) {
        mp.put(val , mp.getOrDefault(val, 0)+1);
        Pair p = new Pair(val , mp.get(val) , indx++);
      
        pq.offer(p);
    }
  
    public int pop() {
        
        Pair p = pq.poll();
        mp.put(p.val , mp.get(p.val)-1);
        return p.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */