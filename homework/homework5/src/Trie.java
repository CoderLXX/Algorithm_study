class TrieNode {
    public char value;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.value = c;
    }
}

public class Trie {

    private TrieNode root;

    Trie() {
        root = new TrieNode();
        root.value = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode sw = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (sw.children[c - 'a'] == null) {
                sw.children[c - 'a'] = new TrieNode(c);
            }
            sw = sw.children[c - 'a'];
        }
        sw.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode sw = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (sw.children[c - 'a'] == null) {
                return false;
            }
            sw = sw.children[c - 'a'];
        }
        return sw.isWord;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode sw = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (sw.children[c - 'a'] == null) {
                return false;
            }
            sw = sw.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("aple"));
        System.out.println(trie.startsWith("app"));
    }
}





/*
* Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
*
* */