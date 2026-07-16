class Solution {
    public int[] sortArray(int[] nums) {
        return merge(0, nums.length-1, nums);
    }

    int[] merge(int i, int j, int[] arr) {
        if (i == j) {
            return new int[] {arr[i]};
        }

        int mid = i + (j - i) / 2;

        int[] left = merge(i, mid, arr);
        int[] right = merge(mid + 1, j, arr);

        return sort( left, right);
    }

    int[] sort(int[] left, int[] right) {
        ArrayList<Integer> ls = new ArrayList<>();
int i = 0;
 int j= 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ls.add(left[i]);
                i++;
            } else {
                ls.add(right[j]);
                j++;
            }
        }

        while (i < left.length) {
            ls.add(left[i]);
            i++;
        }
        while (j < right.length) {
            ls.add(right[j]);
            j++;
        }

        int[] arr = new int[ls.size()];

        for (int k = 0; k < ls.size(); k++) {
            arr[k] = ls.get(k);
        }

        return arr;
    }
}