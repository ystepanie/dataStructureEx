import LinkedList.LinkedListCalculate;
import LinkedList.LinkedListNode;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        /* 이진탐색 알고리즘 자료구조 테스트!!! */
        binarySearch search = new binarySearch();
        //이진 탐색 알고리즘
        int[] numArray = new int[]{1,2,3,4,5,6,7,8};
        // 4라는 값이 몇번째 인덱스에 있는지 테스트
        int binarySearchAnswer = search.binarySearch(numArray, 4);
        System.out.println("binary search answer : " + binarySearchAnswer);

        //배열 꽉찼을때 복사(ArrayList 동작방식)(동적배열)
        int[] doubleSizeAnswer = search.doubleSizeArray(new int[]{1,2,3,4,5}, 6);
        System.out.print("double size array answer : ");
        for(int i : doubleSizeAnswer) {
            System.out.print(i + ",");
        }
        System.out.println();

        /* 피보나치 알고리즘 테스트!!! */
        fibonacciEx fibonacciEx = new fibonacciEx();
        BigInteger answerDown = fibonacciEx.fibonacciDown(10); //하향식 피보나치
        BigInteger answerUp = fibonacciEx.fibonacciUp(10); //상향식 피보나치

        /* 연결리스트 자료구조 테스트!!! */
        LinkedListNode node1 = new LinkedListNode(5, null);
        LinkedListNode node2 = new LinkedListNode(4, node1);
        LinkedListNode node3 = new LinkedListNode(3, node2);
        LinkedListNode node4 = new LinkedListNode(2, node3);
        LinkedListNode node5 = new LinkedListNode(2, node4);

        LinkedListCalculate cal = new LinkedListCalculate();

        LinkedListNode indexNode = cal.LinkedListLookUp(node5, 3);
        // 3번째 인덱스에 어떤 값이 있나 테스트
        System.out.println(indexNode.value);

        cal.LinkedListInsertAfter(node2, new LinkedListNode(6, node1));
        // node2와 1 사이에 추가한 값이 제대로 들어갔는지 previous next pointer로 확인
        System.out.println(node2.next);


    }
}