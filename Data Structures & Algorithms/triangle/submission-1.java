class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minPath(triangle);
    }

    int minPath(List<List<Integer>> t) {
        ArrayList<Integer> dp = new ArrayList<>(t.get(t.size() - 1));

        for (int i = 0; i < dp.size(); i++) {

            int cur = t.get(t.size() - 1).get(i);
            dp.set(i, cur);
        }

        for (int i = t.size() - 2; i >= 0; i--) {

           ArrayList<Integer>cur = new ArrayList<>();

            for (int j = 0; j < t.get(i).size() ; j++) {

                int down = dp.get(j);
                int dl = dp.get(j+1);

                int min = Math.min(down , dl);

               
                cur.add(t.get(i).get(j)+min );
            }

            dp = cur;
        }

        

        return dp.get(0);
    }
}