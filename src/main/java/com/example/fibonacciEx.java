package com.example;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

class fibonacciEx {
	private int n;
	private Map<Integer, BigInteger> storedMap;

	public fibonacciEx() {
		init();
	}

	public void init() {
		storedMap = new HashMap<>();
	}

	// 하향식 피보나치
	public BigInteger fibonacciDown(int n) {
		n -= 1;
		BigInteger answer = f(n - 1).add(f(n - 2));
		System.out.println("fibonacci down : " + answer);

		return answer;
	}

	private BigInteger f(int n) {
		if (n < 2)
			return BigInteger.valueOf(n);

		if (storedMap.containsKey(n)) {
			return storedMap.get(n);
		}
		storedMap.put(n, f(n - 1).add(f(n - 2)));
		return storedMap.get(n);
	}

	// 상향식 피보나치
	public BigInteger fibonacciUp(int n) {
		storedMap.put(0, BigInteger.valueOf(0));
		storedMap.put(1, BigInteger.valueOf(1));
		storedMap.put(2, BigInteger.valueOf(1));

		for (int i = 3; i <= n; i++) {
			storedMap.put(i, storedMap.get(i - 1).add(storedMap.get(i - 2)));
		}

		System.out.println("fibonacci up :" + storedMap.get(n - 1));
		return storedMap.get(n - 1);
	}

}
