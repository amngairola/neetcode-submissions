class Solution {
    public int[] asteroidCollision(int[] ast) {
        int n = ast.length;

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int cur = ast[i];

            if (cur < 0) {
                st.push(cur);
                continue;
            }
            while (!st.isEmpty() &&
             st.peek() < 0 && 
             Math.abs(st.peek()) < cur) {
                st.pop();
            }

            if (!st.isEmpty() && st.peek() < 0) {
                if (Math.abs(st.peek()) == cur)
                    st.pop();
                continue;
            }
            st.push(cur);
        }

        int[] ans = new int[st.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = st.pop();
        }

        return ans;
    }
}