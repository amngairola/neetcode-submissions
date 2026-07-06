class Solution {
    public int[] nextGreaterElement(int[] n1, int[] n2) {
        int n = n1.length;
        int m = n2.length;

       int[] nge = findNge(n2);

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nge.length; i++) {
            mp.put(n2[i], nge[i]);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = mp.get(n1[i]);
        }

        return ans;
    }

    int[] findNge(int[] arr) {
        int[] nge = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return nge;
    }
}