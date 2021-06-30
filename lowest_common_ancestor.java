/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return findLCA(root, p.val, q.val);
    }
    
    public TreeNode findLCA(TreeNode root, int n1, int n2){
        
        if(root==null)
            return null;
        
        if(root.val==n1 || root.val==n2){
            return root;
        }
        
        TreeNode l = findLCA(root.left, n1, n2);
        TreeNode r = findLCA(root.right, n1, n2);
        
        if(l!=null && r!=null)
            return root;
        
        return (l!=null) ? l : r;
    }
}