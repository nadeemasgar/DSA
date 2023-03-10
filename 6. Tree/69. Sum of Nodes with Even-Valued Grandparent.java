// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
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

// DFS

// TC - O(n)
// SC - O(n)


class Solution1 {
    int sum = 0;
    
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        if(root.val % 2 == 0) {
            if(root.left != null) {
                if(root.left.left != null) sum += root.left.left.val;
                if(root.left.right != null) sum += root.left.right.val;
            }
            if(root.right != null) {
                if(root.right.left != null) sum += root.right.left.val;
                if(root.right.right != null) sum += root.right.right.val;
            }
        }

        dfs(root.left);
        dfs(root.right);
        
    }
}

// BFS

// TC - O(n)
// SC - O(n)

class Tuple{
    TreeNode node;
    int grandParent;
    int parent;
    
    Tuple(TreeNode node,int parent, int grandParent){
        this.node = node;
        this.parent = parent;
        this.grandParent = grandParent;
    }
}
class Solution2 {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root,-1,-1));
        int sum=0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                Tuple curr = queue.poll();
                if(curr.grandParent%2==0){
                    sum+= curr.node.val;
                }
                if(curr.node.left!=null){
					// make current node value as parent, and grandparent value from curr.parent
                    queue.offer(new Tuple(curr.node.left, curr.node.val, curr.parent));
                }
                if(curr.node.right!=null){
				// make current node value as parent, and grandparent value from curr.parent
                    queue.offer(new Tuple(curr.node.right, curr.node.val, curr.parent));
                }
            }
        }
        return sum;
    }
}