package tree;

/**
 * Description:
 * 二叉树最近公共祖先
 * @author:edgarding
 * @date:2021/2/19
 **/
public class LowestCommonAncestor {
    /**
     * 寻找p、q的最近公共祖先
     * 1、如果p和q都在root为根的树中，函数返回的就是p和q的LCA
     * 2、如果p和q都不在root为根的树中，返回null
     *
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        // 前序，如果p或q存在于root中，则LCA就为其中之一
        if(root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }
        if(left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

    /**
     * 寻找二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        // 如果两个节点值都比当前节点值小，则说明最近公共祖先在左边
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }
}
