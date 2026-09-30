class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if (n > Integer.MAX_VALUE) return false;
        int m = 1;
        int cnt = 0;
        while(cnt<=32){
            if(m == n) return true;
            if(m>n)return false;
            m = m<<1;
            cnt++;
        }

        return false;
    }
}