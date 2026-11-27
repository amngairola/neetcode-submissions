

class Node {
    int key;
    int val;
    int freq = 1;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Dll {
    Node head;
    Node tail;
    int size = 0;

    Dll() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        size--;
    }

    void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;

        size++;
    }

    Node removeFirst() {
        if (size == 0) return null;

        Node node = head.next;
        remove(node);

        return node;
    }
}

class LFUCache {
    int cap;
    int minFreq;

    HashMap<Integer, Node> freq;
    HashMap<Integer, Dll> freqList;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.minFreq = 0;

        freq = new HashMap<>();
        freqList = new HashMap<>();
    }

    void increaseFreq(Node node) {
        int f = node.freq;

        Dll old = freqList.get(f);
        old.remove(node);

        if (f == minFreq && old.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqList
            .computeIfAbsent(node.freq, k -> new Dll())
            .addLast(node);
    }

    public int get(int key) {
        if (!freq.containsKey(key)) return -1;

        Node node = freq.get(key);

        increaseFreq(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (cap == 0) return;

        // Update existing key
        if (freq.containsKey(key)) {
            Node node = freq.get(key);

            node.val = value;
            increaseFreq(node);

            return;
        }

        // Evict LFU node (LRU among same frequency)
        if (freq.size() == cap) {
            Dll list = freqList.get(minFreq);

            Node removed = list.removeFirst();

            freq.remove(removed.key);
        }

        // Insert new node
        Node node = new Node(key, value);

        freq.put(key, node);

        freqList
            .computeIfAbsent(1, k -> new Dll())
            .addLast(node);

        minFreq = 1;
    }
}
