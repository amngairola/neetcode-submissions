class Solution {
    public int numUniqueEmails(String[] emails) {
        

        HashSet<String> set = new HashSet<>();

        for(String s : emails){
 
            String[]  main  = s.split("@");
            String domain = main[1];

            String[] sub = main[0].split("\\+");

            String name = sub[0];

            String st = "";

            for(char c : name.toCharArray()){

                if(c == '.')continue;
                else st = st+c;
            }

            st = st+'@'+domain;

            set.add(st);

        }

        return set.size();
    }
}