package com.example.Stack;

import com.example.LinkedList.LinkedListNode;

public class LinkedListStackCalculate implements StackCalculate<LinkedListStack> {
	@Override
	public String Peek(LinkedListStack s) {
		String value = null;

		if (s != null) { // null check
			value = s.getLinkedListNode().getValue();
			System.out.println("Peek - " + value);
		}

		return value;
	}

	@Override
	public String Pop(LinkedListStack s) {
		String value = null;

		LinkedListNode head = s.getLinkedListNode();
		if (head != null) { // 헤드 값 가져오고 헤드의 값은 다음 포인터가 가리키는 값으로 세팅해줌
			value = head.getValue();
			s.setLinkedListNode(head.getNext());
		}
		System.out.println("Pop - " + value);
		return value;
	}

	@Override
	public void Push(LinkedListStack s, String value) {
		// 현재 노드 생성 후 다음값을 현재 머리값으로 설정
		LinkedListNode node = new LinkedListNode(value, null);
		node.setNext(s.getLinkedListNode());
		s.setLinkedListNode(node);
		System.out.println("Push - " + value);
	}
}
