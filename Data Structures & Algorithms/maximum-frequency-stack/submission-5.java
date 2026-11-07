 class FreqStack {

    HashMap<Integer, Stack<Integer>> st;
    HashMap<Integer, Integer> mp;
    int freq;
    int maxFreq;

    public FreqStack() {
        st = new HashMap<>();
        freq = 0;
        maxFreq = 0;
        mp = new HashMap<>();
    }

    public void push(int val) {
        if (!mp.containsKey(val)) {
            mp.put(val, 0);
        }

        int freq = mp.get(val);
        int newFreq = freq + 1;
        maxFreq = Math.max(maxFreq, newFreq);

        

        if (!st.containsKey(newFreq)) {
            st.put(newFreq, new Stack<>());
        }

        st.get(newFreq).push(val);
        mp.remove(val);
        mp.put(val, newFreq);
    }

    public int pop() {
        if (maxFreq == 0) return 0;

        Stack<Integer>s  = st.get(maxFreq);
        int val = s.pop();
        
        mp.put(val , mp.get(val) - 1);

        if (s.isEmpty()) {
           
            maxFreq--;
        }

        return val;
    }
}