
class Node {
    Node prev ;
    Node next ;
    int key;
    int val ;

    Node(int key , int val ){
        this.key = key;
        this.val = val;
    }

    Node(int key , int val , Node prev , Node next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;

    }
}
class LRUCache {

    Node head ;
    Node tail ;

    
    HashMap<Integer , Node> mp ;
    int n ;

    public  LRUCache(int cap) {

            n = cap;
            mp = new HashMap<>();

            head = new Node(-1 , -1 );
            tail = new Node(-1 , -1 );

            head.next = tail;
            head.prev = null;

            tail.prev = head;
            tail.next = null;


    }
    
    //delete node

    void delete(Node n){

        Node prev = n.prev;
        Node next = n.next;

        prev.next = next;
        next.prev = prev;

       
    }

    // add in first

    void addInFirst (Node n){
        // Node prev = head;
        // Node next = head.next;

        n.next = head.next ;
        head.next.prev = n;


        head.next = n;
        n.prev = head;

        

    }

    public int get(int key) {
        if(!mp.containsKey(key)) return -1;

        Node n  = mp.get(key);

        delete(n);
        addInFirst(n);

        return n.val;
        
    }
    
    public void put(int key, int val) {
        
        if(mp.containsKey(key)){
            Node n  = mp.get(key);
            n.val = val;
            delete(n);
            addInFirst(n);
        }else{

            if(mp.size() == n){
                Node last = tail.prev;
                delete(last);
                mp.remove(last.key);
            }

            Node n = new Node(key , val);

            addInFirst(n);
            mp.put(n.key , n);
        }
    }
}
