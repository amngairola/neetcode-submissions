class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        

        while (true) {
            
            int sum = getsq(n); 
            if (sum == 1)
                return true;
            
            if (set.contains(sum))
                return false;
            else
                set.add(sum);

            n = sum;
        }

        
    }

    int getsq(int n){
        int sum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;

                int sq = (d* d);
                sum += sq;
            }

            return sum;
    }
}
