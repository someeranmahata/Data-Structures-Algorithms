import java.util.*;
public class InorderTraversal {
    public static class TreeNode {
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
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lt = new ArrayList<>();
        inOrder(lt, root);
        return lt;
    }
    public static  void inOrder(List<Integer> lt, TreeNode root){
        if(root == null)
            return;
        inOrder(lt, root.left);
        lt.add(root.val);
        inOrder(lt, root.right);
    }
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        return height(root, ans);
    }
    public static int height(TreeNode root, int ans){
        if(root == null)
            return ans;
        return Math.max(height(root.left, ans++), height(root.right, ans++));
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        List<Integer> ans = inorderTraversal(root);
        System.out.println(maxDepth(root));
        System.out.println(ans);
    }
}
