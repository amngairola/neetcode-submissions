class Solution {
    public int maxProfit(int[] prices) {
        return bySell( prices );
    }
 

    int bySell( int[] arr)
    {
        int[]prev = new int[2];
        prev[0] = 0;          // not holding
        prev[1] = -arr[0]; 

        for(int i = 1 ; i<arr.length; i++)
        {
            int[]cur = new int[2];
            int nb = prev[0];
            int by = arr[i] + prev[1];
            cur[0] = Math.max(nb , by);
           
              int nS = prev[1];
              int sel = prev[0]-arr[i];
              cur[1]  = Math.max(nS , sel);

            prev = cur;
        }
        
       return prev[0];
    }
}