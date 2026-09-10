class Solution {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        

        int n = gas.length;
        if(n == 1 ) return cost[0] <= gas[0] ? 0 :-1;

        int start =-1;

        for(int i = 0; i<n  ; i++){
            int g = gas[i];
            int req = cost[i];

            if(req < g){
                if(canComplete( i , gas , cost)) return i;
            }
        }

        return -1;
    }

    boolean canComplete(int st , int[] gas , int[]cost){

        int totel = gas[st];

        int j = st;

        while(true){
            
             
             int need = cost[j];

             if(totel >= need){
                totel = totel - need;
                
             }else{
                return false;
             } 

             j+=1;
             if(j == cost.length) j = 0;

             totel+=gas[j];

             if(j == st)break;     
        }
        return true;
    }

}
