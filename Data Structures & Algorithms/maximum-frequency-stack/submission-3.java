class FreqStack {

     HashMap<Integer , Integer> freq ;
     HashMap<Integer , Stack<Integer>> group ;
    int maxi;

    public FreqStack() {
        maxi = 0;
        group = new HashMap<>();
        freq = new HashMap<>();
    }
    
    public void push(int val) {
        
        freq.put(val , freq.getOrDefault(val, 0) +1);
        int f =  freq.get(val);


        maxi = Math.max(maxi , f);

        group.putIfAbsent(f , new Stack<>());
        group.get(f).push(val);
    }
    
    public int pop() {
        
        Stack<Integer> st  = group.get(maxi);

        int val = st.pop();

        freq.put(val , freq.get(val)-1);

        if(st.isEmpty()){
            maxi--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */