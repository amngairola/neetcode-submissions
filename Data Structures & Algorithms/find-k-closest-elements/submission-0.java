class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> 
            {if (b[1] == a[1]) { return b[0] - a[0]; } return b[1] - a[1];

    });
            
             int j = 0;

        while (j < arr.length) {
            pq.offer(new int[] {arr[j], Math.abs(arr[j] - x)});

            while (pq.size() > k) {
                pq.poll();
            }

            j++;
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            ans.add(cur[0]);
        }

        Collections.sort(ans);
        return ans;
    }
}

// if( a - x  <=  b-x   ) a < b  : -> a
// else b