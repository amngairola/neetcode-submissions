class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;

        int[] ng = new int[n];
        

        Stack<Integer> st  = new Stack<>();
        
      int nge = -1;
       for(int i = n-1 ; i>=0 ; i--){
            ng[i] = nge;    
            if(nge < arr[i]) nge = arr[i];  
       }

       return ng;
    }
}