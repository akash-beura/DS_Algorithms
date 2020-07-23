package com.wityo.bst;

public class TrieDriver {

	public static void main(String[] args) {
		int x = 'b' - 'a';
		System.out.println(x);

	}

}

class Trie {
	final TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	// This function will give us the total no. of repetations of the word we're
	// searching else if not found it will return 0
	public int query(String s) {
		TrieNode current = root.next(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			current = current.next(s.charAt(i));
			if (current == null) {
				return 0;
			}
		}
		return current.terminating;
	}

	public void insert(String s) {
		if (root.next(s.charAt(0)) == null) {
			root.trieNode[s.charAt(0) - 'a'] = new TrieNode();
		}
		TrieNode current = root.next(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (current.trieNode[s.charAt(i)] == null) {
				current.trieNode[s.charAt(i)] = new TrieNode();
			}
			current = current.next(s.charAt(i));
		}
		current.terminating++;
	}

	public void delete(String s) {
		TrieNode current = root.next(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			current = current.next(s.charAt(i));
			if (current == null) {
				throw new RuntimeException("This String doesn't exists!");
			}
		}
		if (current.terminating > 0)
			current.terminating--;
	}

	public void update(String obsolete, String updated) {
		delete(obsolete);
		insert(updated);
	}
}

class TrieNode {
	int terminating;
	final TrieNode[] trieNode = new TrieNode[26];

	TrieNode next(final char c) {
		return this.trieNode[c - 'a'];
	}

}
