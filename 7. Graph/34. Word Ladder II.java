// https://leetcode.com/problems/word-ladder-ii/

import java.util.*;

class Solution {

    class Node {
        public String value;
        public Node previous;
        Node(String value) {this.value = value;}
        Node(String value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);

        if(!set.contains(endWord)) return res;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(beginWord));

        while(!q.isEmpty()) {
            int size = q.size();
           
            while(size-- > 0) {
                Node head = q.remove();
                String current_word = head.value;
                Node prev = head.previous;
                set.remove(current_word);

                char[] word_chars = current_word.toCharArray();

                for(int j = 0; j < word_chars.length; j++) {
                    char original_char = word_chars[j];
                    for(char c='a'; c <= 'z'; c++) {
                        if(word_chars[j] == c) continue;
                        word_chars[j] = c;

                        String new_word = String.valueOf(word_chars);
                        Node neighbour = new Node(new_word, head);

                        if(new_word.equals(endWord)) {
                            addNode(res, neighbour);
                            break;
                        }

                        if(set.contains(new_word)) {
                            q.add(neighbour);
                        }
                    }

                    word_chars[j] = original_char;
             
                }
            }

            if(res.size() > 0) break;
        }

        return res;
    }

    public void addNode(List<List<String>> res, Node p) {
        LinkedList<String> ladder = new LinkedList<>();
        
        while(p != null) {
            ladder.addFirst(p.value);
            p = p.previous;
        }

        res.add(ladder);
    }
}