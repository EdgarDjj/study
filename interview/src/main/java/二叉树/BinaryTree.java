package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 二叉树的一些操作
 *
 * @author:edgarding
 * @date:2021/6/8
 **/
public class BinaryTree {

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
}
