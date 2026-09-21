class Solution {
    public int[] plusOne(int[] dig) {
        
        int n = dig.length;
        int l = 0;
        int r  = n-1;

        while(l<=r){
            int temp = dig[l];
            dig[l++] = dig[r];
            dig[r--] = temp;
            
        }


        int carry = 1 ;
        
        int sum = 0;
        
        ArrayList<Integer> ls = new ArrayList<>();


        for(int i = 0; i<n ; i++){

            sum = carry + dig[i];    
            if(sum == 10){
                carry = 1;
                ls.add(0);
            }else{
                ls.add(sum);
                carry = 0;
            }
        }

        if(carry != 0){
            ls.add(carry);
        }

        Collections.reverse(ls);

         int[] ans = new int[ls.size()];
        for(int i = 0; i<ls.size() ; i++){
            ans[i] = ls.get(i);
        }

        return ans;
    }
}
