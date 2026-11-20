/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();

        dfs(root , sb);

        return sb.toString();
    }

    void dfs(TreeNode root , StringBuilder sb){
        if(root == null) {
            return;
        }

        sb.append(root.val).append(',');
        if(root.left  == null) sb.append('#').append(',');
        else  dfs(root.left , sb);
        
       
        if(root.right  == null) sb.append('#').append(',');
         else  dfs(root.right , sb);
    }

    // Decodes your encoded data to tree.
    int i ;
    public TreeNode deserialize(String data) {
        i = 0;
        if(data.length() == 0) return null;
        String[] arr = data.split(",");
        
        return ddfs(arr);
    }


 TreeNode ddfs(String[] arr){
     if(i == arr.length || arr.length == 0) {
            return null;
        }
    String curval = arr[i++] ;

    if(curval.equals("#")){
        return null;
    }
    int val =  Integer.parseInt(curval) ;
    TreeNode root = new TreeNode(val);
      
      if(arr[i] == "#"){
         root.left = null;
         i++;
      }
 
      else root.left =  ddfs(arr);
      
      if(arr[i] == "#"){
            root.right= null;
            i++;
      }
   
      else root.right =  ddfs( arr);


       return root;
    }
}
