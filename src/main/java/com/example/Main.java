package com.example;

import java.math.BigInteger;

import com.example.LinkedList.LinkedListCalculate;
import com.example.LinkedList.LinkedListNode;
import com.example.Queue.Queue;
import com.example.Queue.QueueCalculate;
import com.example.Stack.ArrayListStack;
import com.example.Stack.ArrayListStackCalculate;
import com.example.Stack.LinkedListStack;
import com.example.Stack.LinkedListStackCalculate;
import com.example.Stack.StackCalculate;
import com.example.TreeNode.BinarySearchTree;
import com.example.TreeNode.Dfs;
import com.example.TreeNode.TreeNode;

public class Main {
	public static void main(String[] args) {
		// 이전 테스트 코드
		//preTestCode();

	}

	private static void printSearch(LinkedListNode head) {
		LinkedListNode current = head;
		while (current.getNext() != null) {
			System.out.println("current value - " + current.getValue());
			current = current.getNext();
		}
		System.out.println("current value - " + current.getValue());
	}

	private void preTestCode() {
		/* 이진탐색 알고리즘 자료구조 테스트!!! */
		binarySearch search = new binarySearch();
		//이진 탐색 알고리즘
		int[] numArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		// 4라는 값이 몇번째 인덱스에 있는지 테스트
		int binarySearchAnswer = search.binarySearch(numArray, 4);
		System.out.println("binary search answer : " + binarySearchAnswer);

		//배열 꽉찼을때 복사(ArrayList 동작방식)(동적배열)
		int[] doubleSizeAnswer = search.doubleSizeArray(new int[] {1, 2, 3, 4, 5}, 6);
		System.out.print("double size array answer : ");
		for (int i : doubleSizeAnswer) {
			System.out.print(i + ",");
		}
		System.out.println();

		/* 피보나치 알고리즘 테스트!!! */
		fibonacciEx fibonacciEx = new fibonacciEx();
		BigInteger answerDown = fibonacciEx.fibonacciDown(10); //하향식 피보나치
		BigInteger answerUp = fibonacciEx.fibonacciUp(10); //상향식 피보나치

		/* 연결리스트 자료구조 테스트!!! */
		LinkedListNode node1 = new LinkedListNode("5", null);
		LinkedListNode node2 = new LinkedListNode("4", node1);
		LinkedListNode node3 = new LinkedListNode("3", node2);
		LinkedListNode node4 = new LinkedListNode("2", node3);
		LinkedListNode node5 = new LinkedListNode("1", node4);

		LinkedListCalculate cal = new LinkedListCalculate();

		// 3번째 인덱스 다음 값 보기
		LinkedListNode indexNode = cal.LinkedListLookUp(node5, 3);
		System.out.println(indexNode.getValue());

		// 연결리스트 추가가 제대로 되었나 테스트
		cal.LinkedListInsertAfter(node4, new LinkedListNode("3", node2));

		// 연결리스트 삭제가 제대로 되었나 테스트
		cal.LinkedListDelete(node5, 3);

		printSearch(node5); // 연결리스트 프린트

		/* 배열로 스택만들어 테스트!!! */
		ArrayListStack stack = new ArrayListStack(1, -1, new String[1]);
		StackCalculate stackCal = new ArrayListStackCalculate();

		stackCal.Push(stack, "사과");
		stackCal.Push(stack, "바나나");
		stackCal.Push(stack, "바나나");
		stackCal.Push(stack, "바나나");
		stackCal.Push(stack, "바나나");
		stackCal.Pop(stack);
		stackCal.Peek(stack);

		/* 연결리스트로 스택만들어 테스트!!! */
		LinkedListStack lStack = new LinkedListStack(new LinkedListNode("1", null));
		StackCalculate lStackCal = new LinkedListStackCalculate();

		lStackCal.Push(lStack, "2");
		lStackCal.Push(lStack, "3");
		lStackCal.Push(lStack, "4");
		lStackCal.Push(lStack, "5");
		lStackCal.Pop(lStack);
		lStackCal.Peek(lStack);

		/* 큐로 테스트!!! */
		Queue queue = new Queue(null, null);
		QueueCalculate qCal = new com.example.Queue.QueueCalculate();

		qCal.Enqueue(queue, "1");
		qCal.Enqueue(queue, "2");
		qCal.Dequeue(queue);
		qCal.Dequeue(queue);
		qCal.Dequeue(queue);

		/* dfs 테스트!!! */
		TreeNode treeNode1 = new TreeNode();
		TreeNode treeNode2 = new TreeNode();
		TreeNode treeNode3 = new TreeNode();

		treeNode1.setValue(100);
		treeNode1.setParent(treeNode2);
		treeNode2.setValue(200);
		treeNode2.setLeft(treeNode1);
		treeNode2.setRight(treeNode3);
		treeNode3.setValue(300);
		treeNode3.setParent(treeNode2);

		Dfs dfs = new Dfs();
		dfs.FindValue(treeNode2, 300);
		dfs.InsertTreeNode(new BinarySearchTree(treeNode2), 102);
		dfs.InsertTreeNode(new BinarySearchTree(treeNode2), 202);
		dfs.RemoveTreeNode(new BinarySearchTree(treeNode2), treeNode2);
		// dfs.RemoveTreeNode(new BinarySearchTree(treeNode2), treeNode3);
	}
}