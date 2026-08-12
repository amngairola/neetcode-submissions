class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        HashSet<List<Integer>> hs = new HashSet<>();
        

        Arrays.sort(nums);
        for(int i = 0 ; i<n-2 ; i++){
        int j = i+1;
        int k = n-1;
                while(j < k){
                    if (nums[i]+nums[j]+nums[k] < 0)
                    j++;
                
                  else if(nums[i]+nums[j]+nums[k] > 0)
                    k--;  
                    else{  
                       
                        ArrayList<Integer> cur = new ArrayList(Arrays.asList( nums[i],nums[j],nums[k]));
                        
                        if(!hs.contains(cur)){
 ans.add( cur);
                        hs.add(cur);
                        }
                       
                            j++;
                            k--;
                    }
                }
        }

        return ans;
    }
}
