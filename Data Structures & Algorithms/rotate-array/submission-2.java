class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;

        k = k%n;

        swap(n-k, n-1 , arr);
        swap(0, n-k-1 , arr);
        swap(0 , n-1 , arr);

        
    }

    void swap(int s, int e, int[] arr) {
        while (s <= e) {
            int tem = arr[s];
            arr[s] = arr[e];
            arr[e] = tem;
             s++;
             e--;
        }
    }
}

// index = [0,1,2,3,4,5,6,7]  -> length = 8  - k = 4 -1  = 3;

// [1,2,3,4,5,6,7,8]    e = length -1;   s = length - k - 1; - k = 4;

// [4,3,2,1,8,7,6,5]

// [5,6,7,8,1,2,3,4]

// [8 ||  1,2,,3,4,5,6,7]   - k = 1;
// [ 7,8 ||  1,2,,3,4,5,6]  - k = 2
// [6,7,8 ||  1,2,,3,4,5,]  - k = 3
// [5,6,7,8 ||  1,2,,3,4,]  - k = 4

// [1,2,3,4,5,6,7]  n = 7 , k = 3   n - k = 4

// [4,3,2,1 7,6,5]

// [5,6,7,1,2,3,4]
