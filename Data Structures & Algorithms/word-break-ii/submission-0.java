class Solution {
    List<String> ans;
    HashSet<String> mp;


    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();

        mp = new HashSet<>(wordDict);

        dfs(0 , s , new ArrayList<>());
        return ans;
    }


   void dfs( int i , String s , List<String> ls){
             
             if(i >= s.length()){

                addToAns(new ArrayList<>(ls));
                return;
             }

            
             StringBuilder sb = new StringBuilder();

            for(int j = i ; j<s.length() ; j++){

                sb.append(s.charAt(j));

                if(mp.contains(sb.toString())){

                    ls.add(sb.toString());
                    dfs(j+1 , s , ls);
                    ls.remove(ls.size() -1);

                }
            }
    }

    void addToAns(List<String> ls){

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i< ls.size()  ; i++){
            String s  = ls.get(i);
            sb.append(s);
            if(i != ls.size() -1){
                sb.append(" ");
            }
        }

        ans.add(sb.toString());
        return;
    }
}