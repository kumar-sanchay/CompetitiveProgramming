import java.util.*;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        TreeNode root;
        TreeNode prev;
        
        ArrayList<Integer> added = new ArrayList<>();
        ArrayList<Integer> final_tree = new ArrayList<>();
        
        for(int i=0; i<preorder.length-1; i++){
                        
            final_tree.add(preorder[i]);
            added.add(preorder[i]);
            
            int left;
            if(!added.contains(preorder[i+1]))
                 left = preorder[i+1];
            else
                left = Integer.MAX_VALUE;
            
            int right;
            for(int j=0; j<inorder.length-1; j++){
                
                if(inorder[j]==preorder[i]){
                    
                    if(!added.contains(inorder[j+1]))
                        right = inorder[j+1];
                    else
                        right = Integer.MAX_VALUE;
                }
            }
            
            
            
            if(left==right){
                final_tree.add(null);
                if(left==Integer.MAX_VALUE){
                    final_tree.add(null);
                }else{
                    final_tree.add(left);
                    added.add(right);
                }
                
            }else{
                
                if(left==Integer.MAX_VALUE){
                    final_tree.add(null);
                }else{
                    final_tree.add(left);
                    added.add(left);
                }
                
                if(right==Integer.MAX_VALUE){
                    final_tree.add(null);
                }else{
                    final_tree.add(right);
                    added.add(right);
                }
            
                
            }
            
        }
        
        System.out.println(final_tree);
        
    }
}