class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> st = new Stack<>();
        
        String[] ch = path.split("/");

        for(String s : ch){

            if(s.equals(".") ||  s.equals("")){
                continue;
            }
            else if(s.equals("..")){
                if(!st.isEmpty())st.pop();
                continue;
            } else{
                st.push(s);
            }
        }


        StringBuilder sb = new  StringBuilder();

        for(String s : st){
            sb.append('/').append(s);

        }
        
            if(sb.length() == 0) return "/";
        return sb.toString();
     }
}

// [ . - cur dir

// [ .. - prev dir (pop st.peek())

// [ / // /// -  begin 

// else everything is a valid dir name 
    //--------------
// start w /
// saprated by /
//  not end with /

// must not have '.' '..'
