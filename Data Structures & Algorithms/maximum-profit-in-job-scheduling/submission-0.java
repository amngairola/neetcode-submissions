

class Solution {
    ArrayList<int[]> jobs;
    int maxi;
    public int jobScheduling(int[] st, int[] endT, int[] pr) {
        int n = st.length;
        int[] time = new int[n];

        jobs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = st[i];
            int e = endT[i];
            int p = pr[i];

            jobs.add(new int[] {s, e, p});
        }

        jobs.sort((a, b) -> Integer.compare(a[0], b[0]));

        maxi = 0;

        for (int i = 0; i < jobs.size(); i++) {
            

            dfs(i,  jobs.get(i)[2]);
        }
        return maxi;
    }

    void dfs(int i, int totel) {

       maxi = Math.max(maxi, totel);
        if (i >= jobs.size()) {
           
            return;
        }

        int curE = jobs.get(i)[1];

        for (int j = i + 1; j < jobs.size(); j++) {
            if (jobs.get(j)[0] < curE)
                continue;

            dfs(j, totel + jobs.get(j)[2]);
        }
    }
}