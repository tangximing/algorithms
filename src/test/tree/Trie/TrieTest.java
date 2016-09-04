package tree.Trie;

import org.junit.Test;

/**
 * Created by 西铭 on 2016/8/28.
 */
public class TrieTest {
  @Test
  public void test() {
    Trie trie = new Trie();
    trie.insert("a");
    trie.insert("ab");
    trie.insert("ac");
    trie.insert("abc");
    System.out.println(trie.search("ab"));
    System.out.println(trie.count("a"));

  }
}