
public class Client {

	public static void main(String[] args) {
		MyList<Integer> intList = new MyLinkedList<Integer>();
		
		intList.append(1);
		intList.append(2);
		intList.append(3);
		intList.append(5);
		intList.append(6);
		intList.append(9);
		
		System.out.println(intList);
		
		intList.insert(4, 3);
		intList.insert(7, 6);
		intList.insert(0, 0);
		
		System.out.println(intList);
		
		intList.remove(2);
		intList.removeFirst();
		intList.removeLast();
		
		System.out.println(intList);
		
		System.out.println(intList.getFirst());
		System.out.println(intList.getLast());
		System.out.println(intList.get(3));
		System.out.println(intList.getSize());

	}

}
