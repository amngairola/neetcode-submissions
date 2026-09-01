class Solution {
    public int leastInterval(char[] tasks, int n) {
        

        int[] frq = new int[26];

        for(char c : tasks){
            frq[c-'A']++;
        }

        PriorityQueue<Integer> pq =
    new PriorityQueue<>((a, b) -> b - a);

        for(int num : frq){
            if( num  > 0){
                pq.offer( num );
            }
        }


        int time = 0;

        while(!pq.isEmpty()){

            int cycle = n+1 ;

            ArrayList<Integer> temp = new ArrayList<>();

            while(cycle > 0 && !pq.isEmpty()){
                int freq = pq.poll();
                freq--;

                if(freq > 0){
                        temp.add(freq);
                }

                time++;
                cycle--;
            }

            for(int  num  : temp){
                pq.offer( num );
            }

            if(!pq.isEmpty()){
                time+=cycle;
            }

        }
            return time;
    }
}
