class Solution {
    int maxi;
    public int integerBreak(int n) {
        maxi = 1;

        if(n==2) return 1;
        int i = (int) (n / 2)+1;

        findSum(i, n, new ArrayList<>());

        return maxi;
    }

    void findSum(int i, int sum, ArrayList<Integer> ls) {
        if (sum == 0) {
            getProd(ls);
            return;
        }

        if (i < 1)
            return;

        findSum(i - 1, sum, ls);

        if (i <= sum) {
            ls.add(i);
            findSum(i, sum - i, ls);
            ls.remove(ls.size() - 1);
        }
    }

    void getProd(ArrayList<Integer> ls) {
        int prod = 1;
        for (int i = 0; i < ls.size(); i++) {
            prod *= ls.get(i);
        }

        maxi = Math.max(maxi, prod);
    }
}