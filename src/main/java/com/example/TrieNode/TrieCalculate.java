package com.example.TrieNode;

import java.util.List;

public class TrieCalculate {
	// root 에서부터 시작하는 트라이 탐색
	public TrieNode TrieSearch(Trie trie, String target) {
		return TrieNodeSearch(trie.root, target, 0);
	}

	// trie 검색
	public TrieNode TrieNodeSearch(TrieNode current, String target, int index) {
		if (index == target.length()) { // 마지막 글자일 경우 일치하면 반환
			if (current.isEntry) {
				return current;
			} else {
				return null;
			}
		}

		// 타겟의 탐색해야하는 글자
		char nextLetter = target.charAt(index);
		// 해당 글자를 포함하는 트라이리스트 찾기
		TrieNode nextChild = current.children.get(nextLetter);
		if (nextChild == null) {
			return null;
		} else {
			return TrieNodeSearch(nextChild, target, index + 1);
		}
	}

	// trie 추가
	public void TrieNodeInsert(TrieNode current, String newValue, int index) {
		if (index == newValue.length()) { //마지막 글자 체크
			current.isEntry = true;
		} else {
			char nextLetter = newValue.charAt(index);
			TrieNode nextChild = current.children.get(nextLetter);
			if (nextChild == null) {
				List<TrieNode> childList = current.children;
				childList.add(nextChild);
				current.children.add(new TrieNode(false, TrieNodeInsert(nextChild, newValue, index + 1)));
			} else {
				TrieNodeInsert(nextChild, newValue, index + 1);
			}
		}

	}
}
