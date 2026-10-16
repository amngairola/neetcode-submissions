class Solution {
    HashMap<String, PriorityQueue<String>> mp;
    public List<String> findItinerary(List<List<String>> tickets) {
        mp = new HashMap<>();

        for (List<String> ls : tickets) {
            String src = ls.get(0);
            String desti = ls.get(1);

            mp.putIfAbsent(src, new PriorityQueue<>());
            mp.get(src).offer(desti);
        }

        ArrayList<String> ans = new ArrayList<>();

        dfs("JFK", ans);
        Collections.reverse(ans);
        return ans;
    }

    void dfs(String cur, ArrayList<String> ans) {
        while (mp.containsKey(cur) && !mp.get(cur).isEmpty()) {
            String nbr = mp.get(cur).poll();
            dfs(nbr, ans);
        }

        ans.add(cur);
     return;
    }
}
