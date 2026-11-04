class Solution {
    public long minEnd(int n, int x) {
       long next = x;

        for(int i = 1; i<n ; i++){

                next = x | next +1;

        }

        return next;
    }
}