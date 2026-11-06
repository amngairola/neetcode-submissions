class Solution {

    class Pair {
        String v;
        double value;

        Pair(String v, double value) {
            this.v = v;
            this.value = value;
        }
    }

    Map<String, ArrayList<Pair>> adj = new HashMap<>();
    HashSet<String> vis;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // create a hashMap<String, ArrayList<Pair>> adj

        // pair = {char v, double value}

        // run a loop for i = 0 - values.length()

        for (int i = 0; i < values.length; i++) {

            List<String> cur = equations.get(i);
            double val = values[i];

            adj.putIfAbsent(cur.get(0), new ArrayList<Pair>());
            adj.putIfAbsent(cur.get(1), new ArrayList<Pair>());

            adj.get(cur.get(0)).add(new Pair(cur.get(1), val));
            adj.get(cur.get(1)).add(new Pair(cur.get(0), 1.0 / val));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            List<String> curQ = queries.get(i);

            String u = curQ.get(0);
            String v = curQ.get(1);

            vis = new HashSet<>();

            if (!adj.containsKey(u) || !adj.containsKey(v)) {
                ans[i] = -1.0;
                continue;
            }

            ans[i] = dfs(u, v, adj, 1.0);
        }

        return ans;
    }

    double dfs(String u, String v, Map<String, ArrayList<Pair>> adj, double total) {

        if (u.equals(v)) return total;

        if (vis.contains(u)) return -1.0;

        vis.add(u);

        ArrayList<Pair> nbrs = adj.get(u);

        for (Pair p : nbrs) {

            String nbr = p.v;
            double val = p.value;

            if (!vis.contains(nbr)) {

                double res = dfs(nbr, v, adj, val * total);

                if (res != -1.0) {
                    return res;
                }
            }
        }

        return -1.0;
    }
}