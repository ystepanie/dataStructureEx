package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListCalculate {
    public LinkedListCalculate() {}

    // 처음부터 리스트를 순회하며 n번째의 값을 찾아보자!
    public LinkedListNode LinkedListLookUp(LinkedListNode head, int elementNumber) {
        LinkedListNode current = head;
        int count = 0;

        while(count < elementNumber && current != null) {
            current = current.next;
            count += 1;
        }

        return current;
    }

    // 리스트 사이에 값을 추가해보자!
    public void LinkedListInsertAfter(LinkedListNode previous, LinkedListNode newNode) {
        newNode.next = previous.next;
        previous.next = newNode;
    }

    // n번째에 값을 추가해보자!
    public LinkedListNode LinkedListInsert(LinkedListNode head, int index, int value) {
        if(index == 0) {
            LinkedListNode newHead = new LinkedListNode(value, head.next);
            return newHead;
        }

        LinkedListNode current = head;
        LinkedListNode previous = null;
        int count = 0;

        while(count < index && current != null) {
            previous = current;
            current = current.next;
            count++;
        }

        if(count < index) {
            System.out.println("index is bigger than list length!!");
        }

        LinkedListNode newNode = new LinkedListNode(value, previous.next);
        previous.next = newNode;

        return head;
    }
}
