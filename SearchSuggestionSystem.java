package leetcode;
import java.util.*;

// IMPORTANT TrieNode
class Solution {

    public void dfsSW(TrieNode curNode, List<String> innerList, StringBuilder curWord ){
       
        if(curNode == null)
            return;
        
        if(curNode.isWord == true)
            innerList.add(new String(curWord));
        
        for(int i = 0; i < 26; i++){
            
            if(curNode.nextChars[i] != null){
                
                curWord.append(curNode.nextChars[i].val);
                dfsSW(curNode.nextChars[i],innerList,curWord);
                curWord.deleteCharAt(curWord.length()-1);
                
            }
            
        }
        
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        TrieNode root = new TrieNode('1');

        for (String str : products) {

            TrieNode curNode = root;
            int strlen = str.length();

            for (int i = 0; i < strlen; i++) {
                char ch = str.charAt(i);
                if (curNode.nextChars[ch - 'a'] != null) {
                    curNode = curNode.nextChars[ch - 'a'];
                } else {
                    TrieNode newNode = new TrieNode(ch);
                    curNode.nextChars[ch - 'a'] = newNode;
                    curNode = curNode.nextChars[ch - 'a'];
                }

                if (i == strlen - 1)
                    curNode.isWord = true;
            }

        }

        int swlen = searchWord.length();
        TrieNode curNode = root;
        StringBuilder sb = new StringBuilder();
        List<List<String>> ansList = new LinkedList<>();
        int i = 0;
        for (; i < swlen; i++) {

            char ch = searchWord.charAt(i);
            List<String> innerList = new LinkedList<>();
            curNode = curNode.nextChars[ch - 'a'];
            if (curNode == null)
                break;

            sb.append(ch);
            dfsSW(curNode, innerList, sb);
            Collections.sort(innerList, (a, b) -> {
                return a.compareTo(b);
            });

            List<String> trimmedInnerList = new LinkedList<>();
            int illen = innerList.size();
            for (int j = 0; j < 3; j++) {
                if (j == illen)
                    break;
                trimmedInnerList.add(innerList.get(j));
            }
            ansList.add(trimmedInnerList);

        }

        if (i < swlen) {
            while (i < swlen) {
                ansList.add(new LinkedList<String>());
                i++;
            }
        }

        return ansList;

    }
}

class TrieNode {

    char val;
    boolean isWord;
    TrieNode[] nextChars;

    public TrieNode(char ch) {
        this.val = ch;
        this.isWord = false;
        this.nextChars = new TrieNode[26];
        Arrays.fill(nextChars, null);
    }

}
