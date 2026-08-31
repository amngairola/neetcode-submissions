class Solution {
    class Pair {
        char c;
        int freq;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;

        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
             int cycle = n + 1;
            while (cycle > 0 && !pq.isEmpty()) {

                
                    int f = pq.poll();
                    f--;
                    if (f > 0) {
                        temp.add(f);
                    }
                    time++;
                     cycle--;   
            }

            for (int f : temp) {
                pq.offer(f);
            }

            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}

// 1 T at time

// complete uniq tasks
// if(uniqtasks > n) complete 1 more duplicate task
// wait for n
// start new task
// repete untill all task gets completed