// https://leetcode.com/problems/binary-tree-postorder-traversal/description/

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

// Recursive Approach
// TC - O(n) 
// SC - O(n)

class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);

        return list;
    }

    public void dfs(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;

        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }
}

// Iterative Approach (Using 2 Stack)
// TC - O(n) 
// SC - O(n)

class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        st1.push(root);
        while(st1.size() > 0) {
            TreeNode top = st1.pop();
            st2.add(top.val);

            if(top.left != null) st1.add(top.left);
            if(top.right != null) st1.add(top.right);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(st2.size() > 0) res.add(st2.pop());

        return res;
    }
}

// Iterative Approach (Using 1 Stack)
// TC - O(n) 
// SC - O(n)

class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            ans.addFirst(curr.val);
            if (curr.left != null) {
                st.push(curr.left);
            }
            if (curr.right != null) {
                st.push(curr.right);
            } 
        }
        return ans;
    }
}

class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        TreeNode curr = root;
        while(curr != null || st.size() > 0) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            else {
                TreeNode temp = st.peek().right;
                if(temp == null) {
                    temp = st.pop();
                    list.add(temp.val);

                    while(!st.empty() && temp == st.peek().right) {
                        temp = st.pop();
                        list.add(temp.val);
                    }
                }
                else {
                    curr = temp;
                }
            }
        }

        return list;
    }
}