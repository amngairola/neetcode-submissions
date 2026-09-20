class Solution {
    public long minEnd(int n, int x) {
        
    
        long num = x;
        for(int i = 1 ;i <n ; i++){

                num = x|num+1;

        }
        return num;
    }
}


/* 

n = size
x

construct array -  nums[i] < nums[i+1]
& res of  && bw all ele is x;

return the min posible value of [n-1];

*/