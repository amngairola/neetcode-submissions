class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;

        int five = 0;
        int ten = 0;
        int tw = 0;

        for (int i = 0; i < n; i++) {

            if (bills[i] == 5) {
                five++;
                continue;
            } else if (bills[i] == 10) {
                ten++;
                if (five > 0)
                    five--;
                else
                    return false;

            } else {
                tw++;
                int rem = 15;
                if (ten >= 1) {
                    ten--;
                    rem -= 10;
                } 
                if (rem == 5 && five >= 1) {
                    rem -= 5;
                    five--;
                    continue;
                } 
                if (rem == 15 && five >= 3) {
                    rem -= 15;
                    five -= 3;
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}