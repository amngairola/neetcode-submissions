
class Tries {
    class Node {
        Node ch[] = new Node[26];
        boolean isEnd = false;
    }

    final Node root;

    Tries() {
        root = new Node();
    }

    void insert(String s) {
        Node cur = root;

        for (char c : s.toCharArray()) {
            int i = c - 'a';

            if (cur.ch[i] == null) {
                cur.ch[i] = new Node();
            }

            cur = cur.ch[i];
        }
        cur.isEnd = true;
    }


    boolean isExist(String s) {
        return dfs(root , s , 0);
    }

    boolean dfs(Node cur , String s , int i){

        if(i == s.length()) return cur.isEnd;

        char c = s.charAt(i);


        if(c == '.'){

            for(int j = 0 ; j<26 ; j++){
                if(cur.ch[j] != null && dfs(cur.ch[j] , s , i+1)) return true;
            }
            return false;
        }

        int j = c-'a';

        if(cur.ch[j] == null) return false;

        return dfs(cur.ch[j] , s , i +1);
    }
}

class WordDictionary {
    Tries t ;
    public WordDictionary() {
       t = new Tries();
    }

    public void addWord(String word) {
        t.insert(word);
    }

    public boolean search(String word) {
       return t.isExist(word);
    }
}
