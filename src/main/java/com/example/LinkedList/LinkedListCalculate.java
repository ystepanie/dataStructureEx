package com.example.LinkedList;

public class LinkedListCalculate {
	public LinkedListCalculate() {
	}

	// 처음부터 리스트를 순회하며 n번째의 값을 찾아보자!
	public LinkedListNode LinkedListLookUp(LinkedListNode head, int elementNumber) {
		LinkedListNode current = head;
		int count = 0;

		while (count < elementNumber && current != null) {
			current = current.getNext();
			count += 1;
		}

		return current;
	}

	// 리스트 사이에 값을 추가해보자!
	public void LinkedListInsertAfter(LinkedListNode previous, LinkedListNode newNode) {
		newNode.setNext(previous.getNext());
		previous.setNext(newNode);
	}

	// n번째에 값을 추가해보자!
	public LinkedListNode LinkedListInsert(LinkedListNode head, int index, String value) {
		if (index == 0) {
			LinkedListNode newHead = new LinkedListNode(value, head.getNext());
			return newHead;
		}

		LinkedListNode current = head;
		LinkedListNode previous = null;
		int count = 0;

		while (count < index && current != null) {
			previous = current;
			current = current.getNext();
			count++;
		}

		if (count < index) {
			System.out.println("index is bigger than list length!!");
		}

		LinkedListNode newNode = new LinkedListNode(value, previous.getNext());
		previous.setNext(newNode);

		return head;
	}

	// n번째 값을 삭제해보자!
	public LinkedListNode LinkedListDelete(LinkedListNode head, int index) {
		// head null check
		if (head == null) {
			return null;
		}

		if (index == 0) {
			LinkedListNode newHead = head.getNext();
			head.setNext(null);
			return newHead;
		}

		int count = 0;
		LinkedListNode current = head;
		LinkedListNode previous = null;
		// 인덱스 값까지 순회한다. 도중에 null을 만나면 끝났다는 것.
		while (count < index && current != null) {
			previous = current;
			current = current.getNext();
			count++;
		}

		if (current != null) {
			//현재의 값은 삭제하고 이전 값을 next를 삭제한 다음값으로 바꿔준다.
			previous.setNext(current.getNext());
			current.setNext(null);
		} else {
			System.out.println("index error!!!!");
		}

		return head;
	}
}
