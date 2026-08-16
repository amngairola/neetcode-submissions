class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
            
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i<n ; i++){
            String cur =  tokens[i];
            int a = 0;
            int b = 0;
            int res = 0;
            if (cur.equals("+")){
                if(st.isEmpty())continue;
               
                a = st.pop();
                b = st.pop();
                
                 st.push(b + a);
            }else if(cur.equals("-")){
                if(st.isEmpty())continue;
                a = st.pop();
                b = st.pop();

                st.push(b - a);
            }else if(cur.equals("*")){
                if(st.isEmpty())continue;
                a = st.pop();
                b = st.pop();

                  st.push(b * a);
            }else if(cur.equals("/")){
                if(st.isEmpty())continue;
                a = st.pop();
                b = st.pop();

                  st.push(b / a);
            }else{
                 st.push(Integer.parseInt(cur));
            }
           
        }

        return st.pop();
    }
}
