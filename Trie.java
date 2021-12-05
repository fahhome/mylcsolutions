package leetcode;

import java.util.*;

class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode(-1);
    }

    public void insert(String word) {
        int len = word.length();
        // TrieNode next = new TrieNode();
        TrieNode next = this.root;

        for (int i = 0; i < len; i++) {
            int character = word.charAt(i) - 'a';
            if (next.nextchars[character] == null) {
                next.nextchars[character] = new TrieNode(character);
                next = next.nextchars[character];
            } else {
                next = next.nextchars[character];
            }

            if (i == (len - 1)) {
                next.isWordNode = 1;
            }
        }

    }

    public boolean search(String word) {
        int len = word.length();
        // TrieNode next = new TrieNode();
        TrieNode next = this.root;
        for (int i = 0; i < len; i++) {
            int character = word.charAt(i) - 'a';
            if (next.nextchars[character] == null)
                return false;
            else
                next = next.nextchars[character];

            if (i == len - 1 && next.isWordNode == 0)
                return false;

        }

        return true;
    }

    public boolean startsWith(String prefix) {

        int len = prefix.length();
        // TrieNode next = new TrieNode();
        TrieNode next = this.root;
        for (int i = 0; i < len; i++) {
            int character = prefix.charAt(i) - 'a';
            if (next.nextchars[character] == null)
                return false;
            else
                next = next.nextchars[character];
        }

        return true;

    }

}

class TrieNode {

    int character;
    TrieNode[] nextchars;
    int isWordNode;

    public TrieNode(int character) {
        this.character = character;
        this.nextchars = new TrieNode[26];
        this.isWordNode = 0;
        Arrays.fill(nextchars, null);
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */