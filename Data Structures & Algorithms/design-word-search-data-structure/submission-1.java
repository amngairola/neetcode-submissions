class Tries {
    class Node {
        Node[] ch = new Node[26];
        boolean isEnd = false;
    }

    final Node root;
   Tries (){
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;

        for (char c : word.toCharArray()) {
            int indx = c - 'a';

            if (cur.ch[indx] == null) {
                cur.ch[indx] = new Node();
            }

            cur = cur.ch[indx];
        }

        cur.isEnd = true;
    }

    boolean search(String s) {
        return dfs(0, s, root);
    }

    boolean dfs(int i, String word, Node cur) {
        if (i == word.length()) {
            return cur.isEnd;
        }

        char c = word.charAt(i);

        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (cur.ch[j] != null &&
                 dfs(i + 1, word, cur.ch[j]))  return true;
             }
            return false;
        }

        int j = c - 'a';

        if (cur.ch[j] == null)
            return false;

        return dfs(i + 1, word, cur.ch[j]);
    }
}

class WordDictionary {
   Tries  t;

    public WordDictionary() {
        t = new Tries();
    }

    public void addWord(String word) {
        t.addWord(word);
    }

    public boolean search(String word) {
      return  t.search(word);
    }
}
