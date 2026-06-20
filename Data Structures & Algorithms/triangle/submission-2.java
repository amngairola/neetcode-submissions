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

          

            for (int j = 0; j < t.get(i).size() ; j++) {

                int down = dp.get(j);
                int dl = dp.get(j+1);

                int min = Math.min(down , dl);

               dp.set(j ,t.get(i).get(j)+min );
               
            }

     
        }

        

        return dp.get(0);
    }
}