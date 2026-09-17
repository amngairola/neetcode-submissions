// class Pair{

//     int val ;
//     int freq ;
//     int indx;

//     Pair(int val , int freq , int indx){
//         this.val = val;
//         this.freq = freq ;
//         this.indx = indx;
//     }
// }

class FreqStack {

    HashMap<Integer , Integer> freq;
    HashMap<Integer , Stack<Integer>> grp;
    int maxi;
    // PriorityQueue<Pair> pq;

    public FreqStack() {
        freq = new HashMap<>();
        grp = new HashMap<>();
        maxi = 0;
    }
    
    public void push(int val) {

            int f = freq.getOrDefault(val, 0)+1;

            freq.put(val , f);

            maxi = Math.max(f , maxi);
            
            grp.putIfAbsent(f, new Stack<Integer>());
            grp.get(f).push(val);
    }
  
    public int pop() {
       Stack<Integer> group = grp.get(maxi);
       int val = group.pop();

       freq.put(val, freq.get(val)-1);

       if(group.isEmpty())maxi--;

       return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */