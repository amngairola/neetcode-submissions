class Solution {
     int totel;
    public int subsetXORSum(int[] nums) {
        totel = 0;

        subset(0 , nums , 0);
        return totel;
    }

   
   void subset(int i , int[]arr , int xor){
        if(i>= arr.length){
            totel+=xor;
            return;
        }


        subset(i+1 , arr , xor^arr[i]);

        subset(i+1 , arr , xor);
    }
}