package org.dpo.leetcode.tree;

import org.dpo.exp.TreeNode;

public class SameTree {
    public static void main(String[] args) {

//     1
 //   / \
//   2   3
//   /\  / \
//  4 5  6   7
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(7);
        root1.right.left = new TreeNode(6);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        root2.right.left = new TreeNode(6);


        isSameTree(root1, root2);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        System.out.println(p.val + " AND " + q.val);

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
