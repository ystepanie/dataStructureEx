package com.example.TrieNode;

public class TrieNode {
	boolean isEntry;
	TrieNode[] children;

	public TrieNode() {
		this.isEntry = false;
		this.children = new TrieNode[26]; // 영어 기준 알파벳 개수
	}
}
