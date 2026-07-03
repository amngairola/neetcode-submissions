class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        
 
        int m = f.length;

        for(int i = 0; i<m; i++){
            
                if (n == 0) return true;
            if( f[i] == 0 && canWePlace(i  , f)){
                    f[i] = 1;
                    n--;
                    i++;
            }
             if(n == 0)return true;
        }

        return false;
    }

    boolean canWePlace(int i , int[] arr){

        if(i > 0 && arr[i-1] == 1)return false;
        if(i<arr.length-1 && arr[i+1] == 1)return false;

        return true;
    }
}