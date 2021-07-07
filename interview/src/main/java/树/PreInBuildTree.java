package 树;

import java.util.HashMap;

/**
 * Description:
 * 根据前中序构建二叉树
 *
 * @author:edgarding
 * @date:2021/6/24
 **/
public class PreInBuildTree {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int rootVal = pre[preL];
        TreeNode root = new TreeNode(rootVal);
        if (preL == preR) {
            return root;
        }
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inL;
        int rightSize = inR - rootIndex;
        root.left = build(pre, preL + 1, preL + leftSize, in, inL, rootIndex - 1);
        root.right = build(pre, preR - rightSize + 1, preR, in, rootIndex + 1, inR);
        return root;
    }
}
