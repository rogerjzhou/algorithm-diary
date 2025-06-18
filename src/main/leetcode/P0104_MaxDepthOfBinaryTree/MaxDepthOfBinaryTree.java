package P0104_MaxDepthOfBinaryTree;

/**
 * LeetCode 104 - Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Approach: DFS (Post-order Traversal)
 * - Recursively calculate the depth of left and right subtrees.
 * - The maximum depth of the tree is the greater of the two, plus one for the current node.
 *
 * Steps:
 * 1. Base case: If root is null, return 0.
 * 2. Recursively compute the depth of the left subtree.
 * 3. Recursively compute the depth of the right subtree.
 * 4. Return max(leftDepth, rightDepth) + 1.
 *
 * Time Complexity: O(n) — where n is the number of nodes in the tree.
 * Space Complexity: O(h) — where h is the height of the tree (recursive call stack).
 */
public class MaxDepthOfBinaryTree {

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
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
