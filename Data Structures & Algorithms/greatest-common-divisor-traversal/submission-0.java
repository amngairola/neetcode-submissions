
class Dsu {
    int[] parent, rank;

    Dsu(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int findParent(int a) {
        if (parent[a] != a)
            parent[a] = findParent(parent[a]);
        return parent[a];
    }

    void union(int a, int b) {
        int pa = findParent(a), pb = findParent(b);
        if (pa == pb) return;

        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pa] > rank[pb]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    boolean isConnectedComponent() {
        int p = findParent(0);

        for (int i = 1; i < parent.length; i++)
            if (findParent(i) != p) return false;

        return true;
    }
}

class Solution {

    ArrayList<int[]> edges;
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        Dsu dsu = new Dsu(n);
        edges = new ArrayList<>();
        gcd(nums);

        for (int[] e : edges)
            dsu.union(e[0], e[1]);

        return dsu.isConnectedComponent();
    }

    void gcd(int[] arr) {
      

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (gcdValue(arr[i], arr[j]) > 1)
                    edges.add(new int[]{i, j});
            }
        }

      
    }

    int gcdValue(int a, int b) {
        return b == 0 ? a : gcdValue(b, a % b);
    }
}