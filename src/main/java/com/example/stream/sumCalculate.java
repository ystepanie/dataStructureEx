package com.example.stream;

import java.util.stream.Stream;

public class sumCalculate {
	public sumCalculate() {
	}

	//순차 스트림을 이용해서 합 계산
	public long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
			.limit(n)
			.reduce(0L, Long::sum);
	}

	//반복문을 이용한 합 계산
	public long iterateSum(long n) {
		long result = 0;
		for (long i = 1L; i <= n; i++) {
			result += i;
		}
		return result;
	}
}
