package Stack;

public interface StackCalculate<T> {
	public void Push(T s, String value);

	public String Pop(T s);

	public String Peek(T s);

}
