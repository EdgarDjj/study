package 树;

import java.util.HashMap;

/**
 * Description:
 * 中后续构建二叉树
 *
 * @author:edgarding
 * @date:2021/6/24
 **/
public class PostInBuildTree {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
        if (inL > inR || postL > postR) {
            return null;
        }
        int rootVal = postorder[postR];
        TreeNode root = new TreeNode(rootVal);
        if (postL == postR) {
            return root;
        }
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inL;
        int rightSize = inR - rootIndex;
        root.left = build(inorder, inL, rootIndex - 1, postorder, postL, postL + leftSize - 1);
        root.right = build(inorder, rootIndex + 1, inR, postorder, postR - rightSize, postR - 1);
        return root;
    }
}
