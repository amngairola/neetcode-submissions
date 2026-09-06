class Solution {
    List<List<Integer>> ans;
 

    public List<List<Integer>> combine(int n, int k) {
         ans = new ArrayList<>();
         sub(1, n, k, new ArrayList<>());
         return ans;
    }


     void sub(int i, int n, int k, ArrayList<Integer> temp) {
        if (temp.size() == k) {
           ans.add(new ArrayList<>(temp));
           return;
        }
        if(i > n || temp.size() > k) return ;

        temp.add(i);
        sub(i+1, n, k, temp);

        temp.remove(temp.size() - 1);
        sub(i + 1, n, k, temp);
    }
}