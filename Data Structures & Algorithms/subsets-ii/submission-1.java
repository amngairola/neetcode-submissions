class Solution {
    HashSet<List<Integer>> hs;
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        hs = new HashSet<>();
        ans = new ArrayList<>();
        subset(0, nums, new ArrayList<>());

        return ans;
    }

    void subset(int i, int[] arr, ArrayList<Integer> temp) {
        if (i >= arr.length) {
            
            ArrayList<Integer> ls = new ArrayList(temp);
            Collections.sort(ls);
            if (hs.add(ls)) {
                ans.add(ls);
            }
            return;
        }

        
        subset(i + 1, arr, temp);
        temp.add(arr[i]);
        subset(i + 1, arr, temp);
        temp.remove(temp.size() - 1);
    }
}
