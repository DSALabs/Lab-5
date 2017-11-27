package Lab5;

public class ListArrayBased implements MyList {

	private Comparable[] list;
	private int size = 0;

	public ListArrayBased(int cap) {
		list = new Comparable[cap];
	}

	public ListArrayBased() {
		this(10);
	}

	public void mergeSort() {

	}

	public void quickSortIteratively() {

	}

	public void quickSortRecursively() {

	}

	public void insertionSort() {

	}

	public void bubbleSort() {

	}

	public void bucketSort() {

	}

	public void radixSort() {

	}

	public void heapSort() {

	}

	public void treeSort() {

	}

	// Done
	public boolean add(int index, Comparable E) {

		if (size == list.length) {
			// TODO Create this method
			alloc();
		}

		for (int i = size; i > index; i--) {
			list[i] = list[i - 1];
		}

		list[index] = E;
		size++;
		return true;
	}

	// Done
	public void alloc() {
		Comparable[] temp = new Comparable[size * 2];
		for (int x = 0; x < list.length; x++) {
			temp[x] = list[x];
		}
		list = temp;
		temp = null;
	}

	// Done
	public boolean add(Comparable E) {
		add(size, E);
		return true;
	}

	// Done
	public boolean clear() {
		for (Comparable x : list) {
			x = null;
		}
		size = 0;
		return true;
	}

	// Done
	public boolean contains(Comparable E) {

		if (indexOf(E) > -1) {
			return true;
		} else {
			return false;
		}
	}

	// Done
	public Comparable get(int index) {
		return list[index];
	}

	// Done
	public int indexOf(Comparable E) {

		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(E)) {
				return i;
			}
		}
		return -1;
	}

	// Done
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Done
	public Comparable remove(int index) {
		// TODO
		if (index >= 0 && index < size) {
			Comparable result = list[index];
			for (int i = 0; i < list.length; i++) {
				list[i] = list[i + 1];
			}
			size--;
			return result;
		}
		return null;
	}

	// Done
	public Comparable remove(Comparable E) {

		int i = indexOf(E);
		if (i == -1) {
			return false;
		}
		remove(i);
		return E;
	}

	// Done
	public boolean set(int index, Comparable E) {

		if (index >= 0 && index < size) {
			Comparable temp = list[index];
			list[index] = E;
			return true;
		} else {
			return true;
		}
	}

	// Done
	public int size() {
		// Done
		int count = 0;
		for (Comparable x : list) {
			if (x != null) {
				count++;
			}
		}
		return count;
	}

	//TODO -- currently working on
	public MyList subList(int fromIndex, int toIndex) {
		int tempArrSize = toIndex - fromIndex;
		ListArrayBased subList = new ListArrayBased(tempArrSize);
		for(int i = fromIndex; i <= toIndex; i++) {
			subList.add(list [i]);
		}
		return subList;
	}

	//TODO
	public Comparable[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	// Done
	public boolean swap(int position1, int position2) {
		Comparable x = list[position1];
		Comparable y = list[position2];
		Comparable temp = list[position1];
		x = y;
		y = temp;
		return true;

	}

	@Override
	public boolean shift(int positions) {
		// TODO Auto-generated method stub
		return false;
	}

}
