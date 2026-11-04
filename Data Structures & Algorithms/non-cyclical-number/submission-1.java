class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        HashSet<Integer> set = new HashSet<>();
      
        while (true) {
           int next = 0;

            while (n >= 1) {
                int d = n % 10;
               

                int sqr = mp.containsKey(d) ? mp.get(d) : d * d;
                if(!mp.containsKey(d)) mp.put(d, sqr);
               

                next += sqr;
                 n = n / 10;
            }

            if (next == 1)
                return true;

            if (set.contains(next))
                    return false;
            n = next;
            set.add(next);
        }
    }
}
