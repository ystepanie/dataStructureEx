package com.example.TrieNode;

import java.util.List;

public class TrieNode {
	boolean isEntry;
	List<TrieNode> children;

	public TrieNode(boolean isEntry, List<TrieNode> children) {
		this.isEntry = isEntry;
		this.children = children;
	}
}
