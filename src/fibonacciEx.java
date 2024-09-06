import java.util.HashMap;
import java.util.Map;

class fibonacciEx {
    private int n;
    private Map<Integer, Integer> storedMap;
    public fibonacciEx() {
        init();
    }

    public void init() {
        storedMap = new HashMap<>();
    }

    // 하향식 피보나치
    public int fibonacciDown(int n) {
        n -= 1;
        int answer = f(n-1) + f(n-2);
        System.out.println("fibonacci down : " + answer);

        return answer;
    }

    private int f(int n) {
        if(n<2) return n;

        if(storedMap.containsKey(n)) {
            return storedMap.get(n);
        }
        storedMap.put(n, f(n-1) + f(n-2));
        return storedMap.get(n);
    }

    // 상향식 피보나치
    public int fibonacciUp(int n) {
        storedMap.put(0, 0);
        storedMap.put(1, 1);
        storedMap.put(2, 1);

        for(int i=3; i<=n; i++) {
            storedMap.put(i, storedMap.get(i-1) + storedMap.get(i-2));
        }
        
        System.out.println("fibonacci up :" + storedMap.get(n-1));
        return storedMap.get(n-1);
    }

}
