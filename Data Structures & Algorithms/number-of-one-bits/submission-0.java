class Solution {
    public int hammingWeight(int n) {
        int b = 0;

        while(n != 0){

           if((n & 1) ==  1) b++;

            n = n>> 1;
        }

        return b;
    }
}
