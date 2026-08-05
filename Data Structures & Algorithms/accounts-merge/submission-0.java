

class Solution {

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        DSU dsu = new DSU(n);

        // email -> account index
        Map<String, Integer> emailToAccount = new HashMap<>();

        // Union accounts sharing an email
        for (int i = 0; i < n; i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                String email = account.get(j);

                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    dsu.union(i, emailToAccount.get(email));
                }
            }
        }

        // Leader -> emails
        Map<Integer, List<String>> mergedEmails = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {

            String email = entry.getKey();
            int accountIndex = entry.getValue();

            int leader = dsu.find(accountIndex);

            mergedEmails.putIfAbsent(leader, new ArrayList<>());
            mergedEmails.get(leader).add(email);
        }

        // Build answer
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : mergedEmails.entrySet()) {

            int leader = entry.getKey();
            List<String> emails = entry.getValue();

            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            // Name of the leader account
            account.add(accounts.get(leader).get(0));

            account.addAll(emails);

            result.add(account);
        }

        return result;
    }
}