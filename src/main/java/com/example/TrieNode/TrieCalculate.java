package com.example.TrieNode;

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
		// 글자로 해당 인덱스 찾기
		int nextIndex = LetterToIndex(nextLetter);
		TrieNode nextChild = current.children[nextIndex];
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
			int nextIndex = LetterToIndex(nextLetter);
			TrieNode nextChild = current.children[nextIndex];
			if (nextChild == null) {
				current.children[nextIndex] = new TrieNode();
				TrieNodeInsert(current.children[nextIndex], newValue, index + 1);
			} else {
				TrieNodeInsert(nextChild, newValue, index + 1);
			}
		}
	}

	// trie 삭제
	public boolean TrieNodeDelete(TrieNode current, String target, int index) {
		// 타겟의 마지막 글자인 경우 isEntry를 false 로 바꿔준다.
		if (index == target.length()) {
			if (current.isEntry) {
				current.isEntry = false;
			}
		} else {
			char nextLetter = target.charAt(index);
			int nextIndex = LetterToIndex(nextLetter);
			TrieNode nextChild = current.children[nextIndex];
			if (nextChild != null) {
				if (TrieNodeDelete(nextChild, target, index + 1)) {
					current.children[nextIndex] = null;
				}
			}
		}

		// 마지막 노드가 유효하면 제거 x
		if (current.isEntry) {
			return false;
		}

		// 해당 노드에 자식이 존재할 경우 제거 x
		for (TrieNode n : current.children) {
			if (n != null) {
				return false;
			}
		}

		return true;
	}

	private int LetterToIndex(char letter) {
		int index = -1;
		switch (letter) {
			case 'a':
				index = 0;
				break;
			case 'b':
				index = 1;
				break;
			case 'c':
				index = 2;
				break;
			default:
		}

		return index;
	}
}
