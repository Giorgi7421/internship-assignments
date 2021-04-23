import java.util.Arrays;

public class Stack<T> {
	private Object [] data;
	private int loglen;
	
	public Stack() {
		data = new Object [4];
		loglen = 0;
	}
	
	public int getLength() {
		return loglen;
	}
	
	public boolean isEmpty() {
		return loglen == 0;
	}
	
	public void push(T elem) {
		if(data.length == loglen) {
			data = Arrays.copyOf(data, loglen * 2);
		}
		data[loglen] = elem;
		loglen++;
	}
	
	public void pop() {
		if(!isEmpty()) {
			loglen--;
		}
	}
	
	public T peek() {
		if(!isEmpty()) {
			return (T) data[loglen - 1];
		}
		return null;
	}
}
