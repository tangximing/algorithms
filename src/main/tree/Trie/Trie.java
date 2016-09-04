package tree.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 西铭 on 2016/8/28.
 */
public class Trie {
  /**
   * the root of the trie
   */
  private TrieNode root;
  /**
   * the node in the trie
   */
  private class TrieNode {
    boolean isWord;
    int count;
    Map<Character, TrieNode> children;
    public TrieNode() {
      this.isWord = false;
      this.count = 0;
      children = new HashMap<>();
    }
  }

  public Trie() {
    this.root = new TrieNode();
  }

  /**
   * insert word to the trie
   * @param word the word
   */
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      Character c = word.charAt(i);
      TrieNode tmp = node.children.get(c);
      if (tmp == null) {
        tmp = new TrieNode();
        tmp.count = 1;
      } else {
        tmp.count++;
      }
      node.children.put(c, tmp);
      node = node.children.get(c);
    }
    node.isWord = true;
  }

  /**
   * the word to search
   * @param word the word
   * @return true or false
   */
  public boolean search(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      Character c = word.charAt(i);
      if (!node.children.containsKey(c)) {
        return false;
      }
      node = node.children.get(c);
    }
    return node.isWord;
  }

  /**
   * get the count of the prefix
   * @param prefix prefix
   * @return count
   */
  public int count(String prefix) {
    TrieNode node = root;
    for (int i = 0; i < prefix.length(); i++) {
      Character c = prefix.charAt(i);
      if (!node.children.containsKey(c)) {
        return 0;
      }
      node = node.children.get(c);
    }
    return node.count;
  }
}