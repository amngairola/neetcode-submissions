class Solution {
    int total;
    public int subsetXORSum(int[] nums) {
        total = 0;

        dfs(0 , nums ,  0);

        return total;
    }


   void dfs(int i , int[] arr , int xor){
    if(i>=arr.length){
       total +=  xor;
        return ;
    }

    dfs(i+1 , arr , xor);
    dfs(i+1 , arr , xor ^ arr[i]);
    
   }
}