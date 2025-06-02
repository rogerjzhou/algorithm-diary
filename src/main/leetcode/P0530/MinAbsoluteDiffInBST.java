package P0530;

/**
 * LeetCode 530 - Minimum Absolute Difference in BST
 *
 * Approach:
 * - Use **in-order traversal** to visit nodes in sorted order.
 * - At each node, calculate the difference between the current node's value and the previous visited node's value.
 * - Track the minimum of these differences using a class-level `min` variable.
 * - Use a class-level `prev` variable to keep track of the previous node's value during in-order traversal.
 *
 * Time Complexity: O(n) — where n is the number of nodes (each node visited once).
 * Space Complexity: O(h) — due to the recursion stack, where h is the height of the tree.
 *
 * Key Insight:
 * - In a BST, the in-order traversal yields a sorted list of values.
 * - Therefore, the minimum absolute difference can only occur between two **adjacent** nodes in that order.
 */
public class MinAbsoluteDiffInBST {

    class Solution {

        private Integer prev = null;
        private int min = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            inorder(root);
            return min;
        }

        private void inorder(TreeNode node) {
            if (node == null) return;

            inorder(node.left);

            if (prev != null) {
                min = Math.min(min, node.val - prev);
            }
            prev = node.val;

            inorder(node.right);
        }
    }

     public class TreeNode {
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
}
