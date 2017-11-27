package Lab5;

public interface MyList {
	// Inserts an element into a specified position in the list. This
	// method throws an exception if position value is less than 1 or greater than
	// the list size.
	public boolean add(int index, Comparable o);

	// adds element to the end of the list
	public boolean add(Comparable o);

	// removes all elements from the list
	public boolean clear();

	// Returns true if if the list contains a specified element
	public boolean contains(Comparable o);

	// Returns the element located in the specified position of this list. This
	// method throws an exception if position value is less than 1 or greater than
	// the list size.
	public Comparable get(int index);

	public int indexOf(Comparable o);

	public boolean isEmpty();

	public Comparable remove(int index);

	public Comparable remove(Comparable o);

	public boolean set(int index, Comparable element);

	public int size();

	public MyList subList(int fromIndex, int toIndex);

	public Comparable[] toArray();

	public boolean swap(int postion1, int position2);

	public boolean shift(int positions);
}
