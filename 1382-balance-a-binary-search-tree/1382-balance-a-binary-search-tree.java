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
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);
        return buildBalancedBST(sorted, 0, sorted.size() - 1);
    }
    
    private void inorder(TreeNode root, List<Integer> sorted) {
        if (root == null) {
            return;
        }
        inorder(root.left, sorted);
        sorted.add(root.val);
        inorder(root.right, sorted);
    }
    
    private TreeNode buildBalancedBST(List<Integer> sorted, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sorted.get(mid));
        root.left = buildBalancedBST(sorted, start, mid - 1);
        root.right = buildBalancedBST(sorted, mid + 1, end);
        return root;
    }
}