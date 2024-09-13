package com.example.Stack;

public class ArrayListStackCalculate implements StackCalculate<ArrayListStack> {
	@Override
	public void Push(ArrayListStack s, String value) {
		// 배열이 꽉 찼으면 크기를 늘려준다.
		if (s.top == s.arraySize - 1) {
			String[] newArray = new String[s.arraySize * 2];
			int count = 0;
			while (count <= s.top) {
				newArray[count] = s.array[count];
				count++;
			}
			s.array = newArray;
			s.arraySize = newArray.length;
		}

		s.top++;
		s.array[s.top] = value;
		System.out.println("Push - " + value);
	}

	@Override
	public String Pop(ArrayListStack s) {
		String value = null;

		if (s.top > -1) { // 스택이 비어있나 확인
			value = s.array[s.top];
			s.top -= 1;
		}
		System.out.println("Pop - " + value);
		return value;
	}

	@Override
	public String Peek(ArrayListStack s) {
		String value = null;

		if (s.top > -1) { // 스택이 비어있나 확인
			value = s.array[s.top];
			System.out.println("Peek - " + value);
		}
		return value;
	}
}
