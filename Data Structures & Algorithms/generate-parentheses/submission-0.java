class Solution {
      String s = "()";
      List<String> ans;
    public List<String> generateParenthesis(int n) {
   
        ans  = new ArrayList<>();
        solve(n , new StringBuilder() , 0 , 0 );
        return ans;
      
        
    }

    void solve(int n , StringBuilder sb , int cntOpn , int cntClose){
        if(sb.length() == 2*n ){
            
            ans.add(sb.toString());
            return;
        }


        if(cntOpn<n){
            sb.append('(');
            solve(n , sb , cntOpn+1  , cntClose);
            sb.deleteCharAt(sb.length() -1);
        }

        if(cntClose < cntOpn){
            sb.append(')');
            solve(n , sb , cntOpn  , cntClose+1);
             sb.deleteCharAt(sb.length() -1);
        }
       
    }
}
