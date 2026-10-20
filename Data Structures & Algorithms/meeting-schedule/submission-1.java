/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> ls ) {
        
        int n = ls.size();
       ls.sort((a , b) -> Integer.compare(a.start  , b.start));

        for(int i = 1 ; i<n; i++){

            int e  = ls.get(i-1).end;
            int s = ls.get(i).start;

            if(s < e) return false;

        }

        return true;
    }
}
