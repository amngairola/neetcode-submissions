
class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        int carry = 1;

        List<Integer> ls = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {

            int sum = digits[i] + carry;

            int d = sum % 10;
            carry = sum / 10;

            ls.add(d);
        }

        // If carry is remaining, add it
        if (carry > 0) {
            ls.add(carry);
        }

        // Create answer array
        int[] ans = new int[ls.size()];

        // Reverse while copying
        for (int i = 0; i < ls.size(); i++) {
            ans[i] = ls.get(ls.size() - 1 - i);
        }

        return ans;
    }
}
