public class Main {
    public static void main(String[] args) {
        Search search = new Search();
        //이진 탐색 알고리즘
        int[] numArray = new int[]{1,2,3,4,5,6,7,8};
        int binarySearchAnswer = search.binarySearch(numArray, 1);
        System.out.println("binary search answer : " + binarySearchAnswer);

        //배열 꽉찼을때 복사(ArrayList 동작방식)(동적배열)
        int[] doubleSizeAnswer = search.doubleSizeArray(new int[]{1,2,3,4,5}, 6);
        System.out.print("double size array answer : ");
        for(int i : doubleSizeAnswer) {
            System.out.print(i + ",");
        }
        System.out.println();

        fibonacciEx fibonacciEx = new fibonacciEx();
        int answerDown = fibonacciEx.fibonacciDown(42); //하향식 피보나치
        int answerUp = fibonacciEx.fibonacciUp(42); //상향식 피보나치
    }
}