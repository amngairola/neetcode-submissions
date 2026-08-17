class StockSpanner {

  
    Stack<int[]> pse ;
    static ArrayList<Integer> ls ;

    public StockSpanner() {
       ls = new ArrayList<>() ;
       pse  = new Stack<>() ;
    }
    
    public int next(int price) {
      
      int res =  getPse(price);
       ls.add(price);
        return res;
        
    }

    int getPse(int target){

    int i = ls.size()-1;
    // if(ls.size() ==  1) return 1;

    while(i >= 0 && ls.get(i) <= target){
        i--;
    }
    // if(i < 0) return 1;

    return ls.size() - i ;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */