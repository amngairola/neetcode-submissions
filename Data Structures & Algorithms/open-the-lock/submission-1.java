class Solution {
    public int openLock(String[] dead, String target) {
        HashSet<String> ded = new HashSet<>();

        for(String s: dead){
            ded.add(s);
        }

        if(ded.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.offer("0000");
        vis.add("0000");
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size ; i++){
                String cur = q.poll();
                if(cur.equals(target))return cnt;

                

                for(int j  = 0; j<4;j++){

                    char[] arr = cur.toCharArray();
                    //forwad
                 arr[j] =  (arr[j] == '9') ? '0': (char) (arr[j]+1);
                 String a = new String(arr);
                 if(!vis.contains(a) && !ded.contains(a)){
                    q.offer(a);
                    vis.add(a);


}

arr = cur.toCharArray();
                 arr[j] =  (arr[j] == '0' )? '9':(char)  (arr[j]-1);
                 String b = new String(arr);
                 if(!vis.contains(b) && !ded.contains(b)){
                    q.offer(b);
                    vis.add(b);
                    }
                }
            }
            cnt++;
        }
return -1;
    }
}