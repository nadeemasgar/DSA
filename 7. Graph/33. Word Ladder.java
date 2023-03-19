// https://leetcode.com/problems/word-ladder/description/

// TC - O(M^2 * N )  
// SC - O(M^2 * N )
// where M is the length of each word and N is the total number of words in the input word list.


import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }

        if(!set.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int level = 1;

        while(!q.isEmpty()) {
            int size = q.size();
           
            while(size-- > 0) {
                String current_word = q.remove();
                set.remove(current_word);

                char[] word_chars = current_word.toCharArray();

                for(int j = 0; j < word_chars.length; j++) {
                    char original_char = word_chars[j];
                    for(char c='a'; c <= 'z'; c++) {
                        if(word_chars[j] == c) continue;
                        word_chars[j] = c;

                        String new_word = String.valueOf(word_chars);
                        if(new_word.equals(endWord)) return level + 1;
                        if(set.contains(new_word)) {
                            q.add(new_word);       
                        }
                    }

                    word_chars[j] = original_char;
                }
            }

            level++;
        }

        return 0;
    }
}