class PrefixTree {

    class Node {
        Node[] ch = new Node[26];
        boolean isEnd = false;
    }

    Node root;
    public PrefixTree() {
        root  = new Node();
    }

    public void insert(String word) {

        Node cur = root;

        for(char c : word.toCharArray()){

            int i =  c-'a';

            if(cur.ch[i] == null){
                cur.ch[i] = new Node();
            }

            cur = cur.ch[i];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
         Node cur = root;

        for(char c : word.toCharArray()){

            int i =  c-'a';

            if(cur.ch[i] == null){
                return false;
            }

            cur = cur.ch[i];
        }

        return cur.isEnd ;
    }

    public boolean startsWith(String word) {
        Node cur = root;

        for(char c : word.toCharArray()){

            int i =  c-'a';

            if(cur.ch[i] == null){
                return false;
            }

            cur = cur.ch[i];
        }

        return true;
    
    }
}
