package leetcode.recursive;

import java.util.Stack;

/**
 * 标签：深度优先搜索\递归\迭代
 */
public class Leetcode_100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** 递归
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null || p == null && q != null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    /**
     * 非递归前序遍历判断相等
     * 根左右
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreePre2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        Stack<TreeNode> stackP = new Stack<>();
        stackP.add(p);
        Stack<TreeNode> stackQ = new Stack<>();
        stackQ.add(q);
        while (!stackP.isEmpty() || !stackQ.isEmpty()) {
            TreeNode pNode = stackP.pop();
            TreeNode qNode = stackQ.pop();
            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null) {
                return false;
            }
            if (qNode == null) {
                return false;
            }
            if (pNode.val != qNode.val) {
                return false;
            } else {
                stackP.add(pNode.right);
                stackQ.add(qNode.right);
                stackP.add(pNode.left);
                stackQ.add(qNode.left);
            }
        }
        return true;
    }
}
