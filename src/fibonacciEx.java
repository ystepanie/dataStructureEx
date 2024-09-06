import java.util.HashMap;
import java.util.Map;

class fibonacciEx {
    private int n;
    private Map<Integer, Integer> storedMap;
    public fibonacciEx() {}

    // 하향식 피보나치
    public int fibonacciDown(int n) {
        storedMap = new HashMap<>();
        storedMap.put(0, 0);
        storedMap.put(1, 1);
        int answer = f(n-1) + f(n-2);
        System.out.println(answer);

        return answer;
    }

    private int f(int n) {
        if(storedMap.containsKey(n)) {
            return storedMap.get(n);
        } else {
            storedMap.put(n, f(n-1) + f(n-2));
            return storedMap.get(n);
        }
    }

    // 상향식 피보나치


}
