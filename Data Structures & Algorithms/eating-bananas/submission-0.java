class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        

        int n = piles.length;

        int s = 1;
        int e = 0;
        for(int i =0; i<n ; i++) e = Math.max(e , piles[i]);

int ans = 0;
        while(s<=e){
            int mid = s+(e-s)/2;

            int totelTime = canEat(mid , piles);

            if(totelTime <= h){
                ans = mid;
                e = mid -1;
            }else{
                s = mid+1;
            }
        }

        return ans;
    }

    int canEat(int mid , int[]piles){

        int time= 0;

        for(int i = 0; i<piles.length; i++){
           time += (int) Math.ceil((double) piles[i] / mid);
        }

        return time;
    }
}
