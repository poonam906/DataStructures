
public interface MyList<T> {

	public void append(T data);
	public void insert(T data, int index);
	
	public T remove(int index);
	public T removeFirst();
	public T removeLast();
	
	public T get(int index);
	public T getFirst();
	public T getLast();
	
	public int getSize();
}
