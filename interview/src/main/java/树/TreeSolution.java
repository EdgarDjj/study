package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 二叉树的一些操作
 *
 * @author:edgarding
 * @date:2021/6/28
 **/
public class TreeSolution {
    /**
     * 反转二叉树
     * 后序
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }

    /**
     * 目的：打印二叉树中节点值的和为target的所有路径
     * 约束：根节点 -》 叶子的路径
     * dfs
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtrack(res, new ArrayList<>(), root, target);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> record, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        record.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(record));
        } else {
            backtrack(res, record, root.left, target);
            backtrack(res, record, root.right, target);
        }
        record.remove(record.size() - 1);
    }

    /**
     * 求二叉树的深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        // 平衡二叉树 -》 二叉树中任意节点的左右子树的深度不超过1
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }


    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 1. p q为相互的祖先 -> 前序
     * 2. p q位于同一子树
     * 3. p q位于不同的子树
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // 位于不同的子树
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }


}
