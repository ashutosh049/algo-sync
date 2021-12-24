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
    
    TreeNode lcaNode = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if( root == null){
            return null;
        }
        
        if(exist(root, p) && exist(root, q)){
            lcaNode = lca(root, p, q);
        }
        
        return lcaNode;
    }
    
    private boolean exist(TreeNode root, TreeNode target){
        if(root == null)
            return false;
        
        if(root. val == target.val)
            return true;
        
        return exist(root.left, target) || exist(root.right, target);
        
    }
    
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        
        if( root == null){
            return null;
        }
        
        if( root.val == p.val || root.val == q.val){
            return root;
        }
        
        TreeNode lNode = lca(root.left, p, q);
        TreeNode rNode = lca(root.right, p, q);
        
        if(lNode == null)
            return rNode;
        
        if(rNode == null)
            return lNode;
        
        return root;
    }
    
    
}