/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int nodelvl =0;
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return res;
        dept(root,0);
        return res;
    }
    public void dept(Node root,int num) {
        if (root == null) return;
        if (num + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(num).add(root.val);
        if (root.children != null) {

            
            
            for (Node node : root.children) {
                dept(node,num+1);
            }
        }
    }
}