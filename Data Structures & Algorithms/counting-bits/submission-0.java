class Solution {
    public int[] countBits(int n) {
        
        int[] ans  = new int[n +1];



        for(int i = 1; i<=n ; i++){

            int j = i;

            int cnt  = 0;

            while(j > 0){
           
               if( (j & 1) == 1)cnt++;

                 j = j >> 1;
            }
            ans[i] = cnt;
          

        }
        return ans;
    }
}
