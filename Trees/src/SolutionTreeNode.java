import java.util.*;

public class SolutionTreeNode {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        while(true){
            if(root.val == val)
                return root;
            if(val < root.val){
                if(root.left.val < val){
                    //not possible that we can find the value there
                    break;
                }
                root = root.left;
            }
            else if(val > root.val){
                if(root.right.val > val)
                    break;
                root = root.right;
            }

        }
        return null;
    }
    static class TreeNode {
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
    static TreeNode tree(Integer[] ar){

        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode head = new TreeNode();
        for(int i = 0; i < ar.length; i++){

            if(ar[i] == null)
                continue;
            else{
                int leftind = 2*i + 1;
                int rightind = 2*i + 2;

                if(!map.containsKey(i)){

                    TreeNode node = new TreeNode(ar[i]);
                    if(ar[leftind] == null)
                        map.put(leftind, null);
                    else
                        node.left = new TreeNode(ar[leftind]);
                    map.put(leftind, node.left);

                    if(ar[rightind] == null)
                        map.put(rightind, null);
                    else
                        node.right = new TreeNode(ar[rightind]);
                    map.put(rightind, node.right);

                    if(i == 0)
                        head = node;
                }
                else{
                    TreeNode node = map.get(i);
                    if(ar[leftind] == null)
                        map.put(leftind, null);
                    else
                        node.left = new TreeNode(ar[leftind]);
                    map.put(leftind, node.left);

                    if(ar[rightind] == null)
                        map.put(rightind, null);
                    else
                        node.right = new TreeNode(ar[rightind]);
                    map.put(rightind, node.right);

                }
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
