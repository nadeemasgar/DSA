// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

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

// Approach - DFS
// TC - O(n) 
// SC - O(n)

class Solution1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        
        encode(root, str);
        return str.toString();
    }
    
    public void encode(TreeNode node, StringBuilder s) {
        
        if(node == null) {
            s.append("n ");
            return;
        }
        
        s.append(node.val + " ");
        
        encode(node.left, s);
        encode(node.right, s);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] str = data.split(" ");
      
        return decode(str);
    }
    
    int idx = 0;
    
    public TreeNode decode(String[] s) {
        
        if(idx >= s.length || s[idx].equals("n")) {
            idx++;
            return null;
        } 
        
        String ch = s[idx];
        
        int val = Integer.parseInt(ch);  
        TreeNode node = new TreeNode(val);
        
        idx++;
        
        node.left = decode(s);
        node.right = decode(s);
        
        return node;
            
    }
}

// Approach - BFS
// TC - O(n) 
// SC - O(n)

class Solution2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        String str = "";
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size() != 0) {
            TreeNode node = que.removeFirst();
            if(node != null) {
                str += node.val + " ";
            }
            else {
                str += "# ";
            }

            if(node == null) continue;

            que.add(node.left);
            que.add(node.right);
           
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
                
        String[] arr = data.split(" ");
        LinkedList<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        que.addLast(root);

        int idx = 1;
        while (que.size() != 0) {
            TreeNode rnode = que.removeFirst();

            if (!arr[idx].equals("#")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(arr[idx]));
                rnode.left = leftChild;
                que.addLast(leftChild);
            }
            idx++;

            if (!arr[idx].equals("#")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(arr[idx]));
                rnode.right = rightChild;
                que.addLast(rightChild);
            }
            idx++;
        }

        return root; 
    }
}