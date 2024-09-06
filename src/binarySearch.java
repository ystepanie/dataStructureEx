import java.util.Arrays;

class binarySearch {
    public binarySearch() {}

    // 이진탐색 알고리즘
    public int binarySearch(int[] numArray, int num) {
        // 이진 탐색은 정렬된 배열을 조건으로 한다.
        Arrays.sort(numArray);
        // 처음과 끝, 중간의 포인터를 설정해준다.
        int startP = 0;
        int endP = numArray.length-1;

        while(startP <= endP) {
           int middleP = (int)Math.floor((startP + endP) / 2);
           if(numArray[middleP] > num) { //중간값보다 작으면
               endP = middleP - 1; //endP 이동
           } else if(numArray[middleP] < num) {//중간값보다 크면
               startP = middleP + 1; //startP 이동
           } else {
               return middleP;
           }
        }

        return -1;
    }

    // 배열 크기 꽉찼을때 두배로 복사
    public int[] doubleSizeArray(int[] numArray, int num) {
        int[] newArray = new int[numArray.length*2];
        int length = 0;

        while(numArray.length > length) {
            newArray[length] = numArray[length];
            length++;
        }

        newArray[length] = num;

        return newArray;
    }
}
