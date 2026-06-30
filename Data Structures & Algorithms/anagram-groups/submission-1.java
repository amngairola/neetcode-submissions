class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] vis= new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];

            if(vis[i])continue;

            char[] arr = cur.toCharArray();
            Arrays.sort(arr);

            String s1 = new String(arr);

            List < String > temp = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {
                String c = strs[j];
                char[] arrr = c.toCharArray();
                Arrays.sort(arrr);

                String s2 = new String(arrr);

                if (s1.equals(s2) && ! vis[j]) {
                    temp.add(c);
                    vis[j] = true;
                }
            }

            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }
}
