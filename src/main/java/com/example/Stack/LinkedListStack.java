package com.example.Stack;

import com.example.LinkedList.LinkedListNode;

public class LinkedListStack {
	private LinkedListNode linkedListNode;

	public LinkedListStack(LinkedListNode linkedListNode) {
		this.linkedListNode = linkedListNode;
	}

	public LinkedListNode getLinkedListNode() {
		return linkedListNode;
	}

	public void setLinkedListNode(LinkedListNode linkedListNode) {
		this.linkedListNode = linkedListNode;
	}
}
