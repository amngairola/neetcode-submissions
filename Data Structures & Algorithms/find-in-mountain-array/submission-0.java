/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mArr) {
        int n = mArr.length();

        int s = 0;

        int e = n-1;
        int ans = 0;

        int peak = findPeak(mArr, s, e);

        int lft = findInLeft(s, peak, target, mArr);
        if (lft != -1)
            return lft;

        return findInRight(peak+1, e, target, mArr);

       
    }

    int findPeak(MountainArray arr, int s, int e) {
        while (s <e) {
            int mid = s + (e - s) / 2;

            int cur = arr.get(mid);
            int next =  arr.get(mid + 1);

            if (cur < next)s = mid + 1;
            else  e = mid ;

            
        }

        return s;
    }
    int findInLeft(int s, int e, int k, MountainArray arr) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            int cur = arr.get(mid);
            if (cur == k)
                return mid;

            else if (cur > k)
                e = mid - 1;
            else
                s = mid + 1;
        }

        return -1;
    }

    int findInRight(int s, int e, int k, MountainArray arr) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            int cur = arr.get(mid);
            if (cur == k)
                return mid;

            else if (cur > k)
                s = mid + 1;
            else
                e = mid - 1;
        }

        return -1;
    }
}