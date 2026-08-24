class Solution {
    public int maxProfit(int[] price) {
        

        int buy = price[0];
        int sell = 0;
        int maxi = 0;

        for(int i = 1; i<price.length ; i++){

            if(buy > price[i]){
                buy = price[i];
                sell = 0;
            }

            sell = Math.max(sell , price[i]);

            maxi = Math.max(maxi , sell - buy);
        }

        return maxi;
    }
}
