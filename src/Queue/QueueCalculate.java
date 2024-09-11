package Queue;

import LinkedList.LinkedListNode;

public class QueueCalculate {

	public QueueCalculate() {
	}

	public void Enqueue(Queue queue, String value) {
		LinkedListNode node = new LinkedListNode(value, null);
		// 비어있는 큐일 경우 프론트와 백 포인터 모두 해당 노드를 가리킨다.
		if (queue.back == null) {
			System.out.println("First Enqueue - " + value);
			queue.front = node;
			queue.back = node;
		} else {
			System.out.println("Enqueue - " + value);
			queue.back.setNext(node);
			queue.back = node;
		}
	}

	public String Dequeue(Queue queue) {
		if (queue.front == null) {
			System.out.println("Queue is null!!!");
			return null;
		}

		String value = queue.front.getValue();
		queue.front = queue.front.getNext();
		// front next가 비어있다면 값이 하나였다는 소리이므로 백 포인터도 널로 바꾼다.
		if (queue.front == null) {
			queue.back = null;
		}
		System.out.println("Dequeue - " + value);
		return value;
	}

}
