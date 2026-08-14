class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        for (int cur : arr) {
            

            while (!st.isEmpty() && cur < 0 && st.peek() > 0 ) {
                if(st.peek() < Math.abs(cur)){
                    st.pop();
                    continue;
                }
                
                if (st.peek() == Math.abs(cur)) {
                // isSameSize = true;
                    st.pop();
                    cur = 0;
                }
                cur = 0;
                break;
            }
            if ( cur != 0) {
                st.push(cur);
            }
        }
        int[] ans = new int[st.size()];
        int i = 0;
        for(i = ans.length-1 ; i>=0 ; i--){
        
            ans[i] = st.pop();
        }
        
        return ans;
    }

    
}

// index - relative postion
// val[i] = size;
// +  -> ||   -  <-

// 2   4  ---->

//               <---- -6    -1
//  -6 , -1
//  2 ---->  <---- -1

//  2 ----> WON