/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // dfs(root,0,res);
        


        bfs(root,res);
        return res;
    }
    public void dfs(TreeNode root,int lvl,List<List<Integer>> res){
        if(root == null) return;
        if(lvl+1>res.size()) res.add(new ArrayList<>());
        res.get(lvl).add(root.val);
        dfs(root.left,lvl+1,res);
        dfs(root.right,lvl+1,res);
    }
    public void bfs(TreeNode root,List<List<Integer>> res){
        if(root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                if(node.left != null){
                    nodes.add(node.left);
                }
                if(node.right != null){
                    nodes.add(node.right);
                }
            }
             res.add(results);
        }
    }
}