
class Node {
    int key, val, freq = 1;
    Node prev, next;

    Node(int k, int v) { key = k; val = v; }
}

class Dll {
    Node left = new Node(0, 0), right = new Node(0, 0);
    int size = 0;

    Dll() { left.next = right; right.prev = left; }

    void pushRight(Node n) {
        n.prev = right.prev;
        n.next = right;
        right.prev.next = n;
        right.prev = n;
        size++;
    }

    void pop(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }

    Node popLeft() {
        Node n = left.next;
        pop(n);
        return n;
    }
}

class LFUCache {
    Map<Integer, Node> mp = new HashMap<>();
    Map<Integer, Dll> freq = new HashMap<>();
    int capacity, lfuCnt;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    void increaseFreq(Node n) {
        int f = n.freq;
        Dll old = freq.get(f);
        old.pop(n);

        if (f == lfuCnt && old.size == 0) lfuCnt++;

        n.freq++;
        freq.computeIfAbsent(n.freq, k -> new Dll()).pushRight(n);
    }

    public int get(int key) {
        if (!mp.containsKey(key)) return -1;
        Node n = mp.get(key);
        increaseFreq(n);
        return n.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (mp.containsKey(key)) {
            Node n = mp.get(key);
            n.val = value;
            increaseFreq(n);
            return;
        }

        if (mp.size() == capacity) {
            Node n = freq.get(lfuCnt).popLeft();
            mp.remove(n.key);
        }

        Node n = new Node(key, value);
        mp.put(key, n);
        freq.computeIfAbsent(1, k -> new Dll()).pushRight(n);
        lfuCnt = 1;
    }
}
