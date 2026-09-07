class Solution {
    public int numRescueBoats(int[] p, int lim) {
        
        int n = p.length;
        Arrays.sort(p);
        
        int cnt = 0;
        int r = n-1;

        while(r >= 0 && p[r] == lim ){
            cnt++;
            r--;
        }

        int i = 0;
        while (i <= r ){
            if(p[i] + p[r] > lim){
                cnt++;
                r--;
            }else{
                cnt++;
                i++;
                r--;
            }
        }

       return cnt; 

    }
}

// p[i] = weight
// max pepole = 2 
// max weight = limit

//find min number of required boat;


// find how many (subset of length two) sum = limit