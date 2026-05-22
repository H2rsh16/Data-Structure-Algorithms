// Last updated: 22/05/2026, 11:23:04
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
    List<Integer> lst = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }

        traverse(root);
        lst.add(root.val);
        return lst;
    }
    private void traverse(Node root){
        if(root == null){
            return;
        }

        for(Node c: root.children){
            traverse(c);
            lst.add(c.val);
        }
    }
}