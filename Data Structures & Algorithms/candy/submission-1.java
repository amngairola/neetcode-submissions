class Solution {
    static int maxi ;
    public int candy(int[] arr) {
        
         maxi = 0;
        int[]left= new int[arr.length +1];
        int[]right = new int[arr.length +1];
       
        int n = arr.length;

            for(int i = 0; i< n ; i++){
                
                if( i> 0 && arr[i] > arr[i-1] ){
                   left[i]= 1+left[i-1];
                }else{
                     left[i] = 1;
                }
            }

            for(int i = n-1; i>= 0 ; i--){
                

               
                if(i<n-1 && arr[i] > arr[i+1] ){
                   right[i] = 1+ right[i+1];
                } else{
                    right[i] = 1;
                }
                maxi += Math.max(left[i]  , right[i]);
            }

              
        return maxi;
        
    }
    

   
}