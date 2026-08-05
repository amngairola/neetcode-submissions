class TimeMap {

    class Pair{
        String val ;
        int ts ;

        Pair (String val , int ts){
            this.val = val;
            this.ts = ts;
        }
    }

    HashMap<String , ArrayList<Pair> > mp ;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(!mp.containsKey(key))mp.put(key , new ArrayList<>());

        mp.get(key).add(new Pair(value , timestamp));
    }
    
    public String get(String key, int timeStamp) {
        if(!mp.containsKey(key))return "";
        ArrayList<Pair> ls = mp.get(key);
        
        int s = 0;
        int e = ls.size()-1;
        String  ans = "";
        while(s<=e)
        {
            int mid = s+(e-s)/2;

            int ts = ls.get(mid).ts;

            if(ts <= timeStamp){
                ans = ls.get(mid).val;
                s = mid+1;
            }else{
                e = mid-1;
            }
        }

        return ans;
    }
}
