class Solution {
    public double[] calcEquation(
            List<List<String>> eq,
            double[] vals,
            List<List<String>> q) {

        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();

        int n = eq.size();

        for (int i = 0; i < n; i++) {

            List<String> cur = eq.get(i);

            String u = cur.get(0);
            String v = cur.get(1);

            double val = vals[i];

            adj.putIfAbsent(u, new HashMap<>());
            adj.putIfAbsent(v, new HashMap<>());

            adj.get(u).put(v, val);
            adj.get(v).put(u, 1.0 / val);
        }

        double[] ans = new double[q.size()];

        for (int i = 0; i < q.size(); i++) {

            String src = q.get(i).get(0);
            String dest = q.get(i).get(1);

            if (!adj.containsKey(src) || !adj.containsKey(dest)) {
                ans[i] = -1.0;
                continue;
            }

            if (src.equals(dest)) {
                ans[i] = 1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();

            ans[i] = dfs(src, dest, adj, 1.0, visited);
        }

        return ans;
    }

    double dfs(
            String s,
            String d,
            HashMap<String, HashMap<String, Double>> adj,
            double cost,
            Set<String> visited) {

        if (s.equals(d)) {
            return cost;
        }

        visited.add(s);

        HashMap<String, Double> cur = adj.get(s);

        for (Map.Entry<String, Double> entry : cur.entrySet()) {

            String next = entry.getKey();
            double value = entry.getValue();

            if (visited.contains(next)) {
                continue;
            }

            double result = dfs(
                    next,
                    d,
                    adj,
                    cost * value,
                    visited
            );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }
}