class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);

        int n = arr.length;
        int s = arr[0], e = arr[n-1] ;
        int mid = n / 2;
       
        double ans = 0.0;
        if (n % 2 != 0) {
           ans = (double) arr[mid];
        } else {
            
            ans = (arr[mid - 1]  + arr[mid]) / 2.0;
        }

        return ans;
    }

    int[] merge(int[] a ,int[] b) {
        int s = 0;
        int e = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (s < a.length && e < b.length) {
            if (a[s] <= b[e]) {
                ans.add(a[s]);
                s++;
            } else {
                ans.add(b[e]);
                e++;
            }
        }

        while (s < a.length) {
            ans.add(a[s]);
            s++;
        }

        while (e < b.length) {
            ans.add(b[e]);
            e++;
        }
        int[] ab = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            ab[i] = ans.get(i);
        }

        return ab;
    }
}
