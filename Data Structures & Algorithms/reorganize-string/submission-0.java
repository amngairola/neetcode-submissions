
class Pair {
        char c;
        int freq;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
class Solution {
    
    public String reorganizeString(String s) {
        int[] frq = new int[26];

        for (char c : s.toCharArray()) {
            frq[c - 'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int i = 0; i < 26; i++) {
            int n = frq[i];
            if (n > 0) {
                pq.offer(new Pair((char) ('a' + i), n));
            }
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = null;

        while (!pq.isEmpty()) {
            ArrayList<Pair> temp = new ArrayList<>();

            Pair cur = pq.poll();
            sb.append(cur.c);
            cur.freq--;

            if (prev != null && prev.freq > 0)
                pq.offer(prev);

            // Current character becomes previous
            prev = cur;
        }
        if (prev != null && prev.freq > 0) {
            return "";
        }
        return sb.toString();
    }
}

// get the freq of each
// put all in pq <char , freq>   freq[0] > freq[1]
// newS
// while !pq.isEmpty():

// cycle = pq.size();
// while cycle > 0 :
// Pair p = pq.poll()
// s = s + p.ch
// p.freq --
// if( p.freq > 1) temp.add( p)
// cycle --
// flush all from temp to pq
