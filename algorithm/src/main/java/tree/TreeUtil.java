package tree;

/**
 * Description:
 * 二叉树的一些操作
 * @author:edgarding
 * @date:2021/2/19
 **/
public class TreeUtil {
    /**
     * 二叉树的深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 判断是否是个平衡二叉树
     * 「如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。」
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private static int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

}
