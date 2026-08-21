class Solution {
    public int maxArea(int[] h) {
        
        int n = h.length;

        int maxWater = 0;

        int l = 0;
        int r = n-1;

        while(l<=r){

                int minH = Math.min(h[l] , h[r]);
                int w = r-l;
                maxWater = Math.max(maxWater , minH*w);
            
            if(h[l] <= h[r]){
                l++;
            }else{
                r--;
            }

        }

        return maxWater;
    }
}
