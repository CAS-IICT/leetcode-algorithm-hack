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
    public boolean isSymmetric(TreeNode root) {
        // myidea： 也是采用递归，用一个额外的辅助函数，来进行判断
        return helper(root,root);
        
    }
    // 辅助函数，传入的参数为根节点，然后递归依次判断root1的左子树与root2的右子树是否相同
    public boolean helper(TreeNode root1,TreeNode root2){
        // 递归出口
        // 如果传入的两个树节点均不存在肯定是true
        if(root1 == null && root2 == null) return true;
        // 如果只有一个不存在，那么肯定是错误的 返回false
        if(root1 == null || root2 == null) return false;
        // 判断传入的树节点的值是否相同 递归判断root1的左子树与root2的右子树，以及root1的右子树与root2的左子树是否相同
        return (root1.val == root2.val) && helper(root1.left,root2.right) && helper(root1.right,root2.left);

    }
}
