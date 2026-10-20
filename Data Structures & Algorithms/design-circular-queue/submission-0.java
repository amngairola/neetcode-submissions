
class Node {

    int val;
    Node prev ;
    Node next;

    Node(int val){
        this.val = val;
        this.prev = null ;
        this.next = null;
    }

}


class MyCircularQueue {
    int size ;
    Node head ;
    Node tail;  

    public MyCircularQueue(int k) {

            size = k;
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev  = head;
    }
    
    public boolean enQueue(int value) {

        if(size == 0) return false;
            Node cur = new Node(value);
            Node prev = tail.prev ;
           
            cur.prev = prev;
            prev.next = cur;

            cur.next = tail;
            tail.prev = cur;

            size--;

            return true;
            
    }
    
    public boolean deQueue() {
        
        if(head.next == tail) return false;
        
        Node del=head.next;

        head.next = del.next;
        del.next.prev = head;

        del.next  = null;
        del.prev = null;
        size++;
        return true;
    }
    
    public int Front() {
        
        if(head.next == tail) return -1;

       return head.next.val;
    }
    
    public int Rear() {
        if(tail.prev == head) return -1;

        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return head.next == tail;
    }
    
    public boolean isFull() {
        return size == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */