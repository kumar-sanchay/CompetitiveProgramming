import java.util.*;

class TreeNode {
 int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        TreeNode tree; 
        int middle_idx = 0;
        ArrayList<Integer> added = new ArrayList<>();

        for(int idx=0; idx<inorder.length; idx++){

            if(inorder[idx]==preorder[0]){
                middle_idx=idx;
                break;
            }
        }

        tree = recurse(preorder, inorder, 0, middle_idx);
        return tree;
    }

    public TreeNode recurse(int[] preorder, int[] inorder, int idx, int middle_idx){


        TreeNode tree = new TreeNode();

        tree.val = preorder[idx];

        if(idx==preorder.length-1)
            return tree;

        for(int i=middle_idx; i>=0; i--){
            if((idx+1)<preorder.length && preorder[idx+1]==inorder[i]){
                tree.left = recurse(preorder, inorder, idx+1, middle_idx);
                break;
            }
            else
                tree.left = null;
        }
        
        for(int i=middle_idx; i<inorder.length; i++){
            if((idx+2)<preorder.length && preorder[idx+2]==inorder[i]){
                tree.right = recurse(preorder, inorder, idx+2, middle_idx);
                break;
            }
            else
                tree.right = null;
        }
        
        return tree;
    }
}