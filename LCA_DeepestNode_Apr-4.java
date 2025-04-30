/*
1123. Lowest Common Ancestor of Deepest Leaves
Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

Recall that --
The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair ans = LCA(root);
        return ans.root;
    }
    public Pair LCA(TreeNode root ){
        if(root == null)return new Pair(0 , new TreeNode());
        Pair left = LCA(root.left );
        Pair right = LCA(root.right);
        if(left.height == right.height ){
            return new Pair(left.height + 1 , root);
        }
        else if(left.height > right.height){
            return new Pair(left.height + 1 , left.root);
        }
        return new Pair(right.height + 1 , right.root);
    }
}
class Pair{
    int height ;
    TreeNode root;
    Pair(int h , TreeNode r){
        height = h;
        root = r;
    }
}

/*
Thought Process: Lowest Common Ancestor of Deepest Leaves
The goal is to find the lowest common ancestor (LCA) of the deepest nodes in a binary tree.
To do this, we need to know:
The depth (height) of each subtree.
The node where the deepest nodes converge.
🔁 How we solve it:

Use recursion to traverse the tree from bottom-up.
For each node, calculate:
The height of its left subtree.
The height of its right subtree.
Based on heights:
If both heights are equal → deepest nodes are in both subtrees → current node is their LCA.
If one side is deeper → deepest nodes are only in that subtree → LCA is in that subtree.
At each step, we return:
The height from that node down to the deepest leaf.
The LCA found so far in that subtree.
Finally, return the node that is the LCA of all deepest leaves.

*/
