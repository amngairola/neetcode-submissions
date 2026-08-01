class Solution {
    public int shipWithinDays(int[] weights, int days) {
        return minEatingSpeed(weights  ,days);
    }

     public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int s = 1;
        int e = 0;
        for (int i = 0; i < n; i++){ 
            e +=piles[i];
            s = Math.max(s , piles[i]);
           }

        int ans = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            int totelTime = canEat(mid, piles);

            if (totelTime <= h) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    int canEat(int maxW, int[] arr) {
        int days = 1;
        int w = 0;
        for (int i = 0; i < arr.length; i++) {
            
            if(w+arr[i] <= maxW){
                w+=arr[i];
               
            }else{
                days++;
                w = arr[i];
            }
        }

        return days;
    }
}