class MyStack {

    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>();
       
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        rotateQ(q1);

        int node = q1.poll();

        return node;

    }
    
    public int top() {
        rotateQ(q1);

        int node = q1.poll();
        q1.offer(node);

        return node;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }


    void rotateQ(Queue<Integer> q){

        int n = q.size();

        while(n-- > 1){

            int node = q.poll();
            q.offer(node);
           
        }
    }
}

/**

 7 1,2,3,4,5,6

 7,6,5,4,3,2,1

 
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */