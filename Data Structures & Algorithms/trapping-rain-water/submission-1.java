class Solution {
    public int trap(int[] arr) {
        
        int n = arr.length;


        int l =  0;
        int r = n-1;

        int lMax = arr[l];
        int rMax = arr[r];

        int cnt = 0;

        while(l<=r){

            if(lMax <= rMax){

                if(lMax > arr[l]){
                    cnt += lMax - arr[l];
                }else{
                    lMax = arr[l];
                }

                l++;


            }else{
                if(rMax > arr[r]){
                    cnt += rMax - arr[r];
                }else{
                    rMax = arr[r];
                }

                r--;
            }
        }

        return cnt;
    }
}
