
public class ListArrayBased implements MyList {

	private Comparable[] list;
	private int size = 0;

	public ListArrayBased(int cap) {
		list = new Comparable[cap];
	}

	public ListArrayBased() {
		this(10);
	}
	
	void merge(int l, int m, int r) {
		
		int left = m -l+1;
		int right =r -m ;
		Comparable leftArray[] = new Comparable[left];
		Comparable rightArray[] = new Comparable[right];
		for(int i = 0; i<left; i++) {
			leftArray[i] = list[l+i];
		}
		for(int j = 0; j<right; j++) {
			rightArray[j] = list[m+1+j];
		}
		int i = 0;
		int j = 0;
		int k = l;
		while(i<left && j< right) {
			if(leftArray[i].compareTo(rightArray[j]) <= 1) {
				list[k] = leftArray[i];
				i++;
			}
			else {
				list[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while(i< left) {
			list[k] = leftArray[i];
			i++;
			k++;
		}
		while(j< right) {
			list[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public void mergeSort(int left, int right) {
		if(left < right) {
			int m = (left+right)/2;
			mergeSort(left, m);
			mergeSort(m+1, right);
			merge(left,m,right);
			
			
		}
	}
	void partition(int first, int last) {
		Comparable p = list[first];
		int lastS1 = first;
		int firstUnknown = first+1;
		while(firstUnknown<=last) {
			if(list[firstUnknown].compareTo(p) <1) {
				swap(firstUnknown, lastS1+1);
				lastS1++;
				firstUnknown++;
			}
			else {
				firstUnknown++;
			}
		}
		swap(first, lastS1);
	}
	
	public void quickSortIteratively() {
		partition(0, size);
	}
	
	int recPartition(int low, int high)
	    {
	        Comparable pivot = list[high]; 
	        int i = low; // index of smaller element
	        for (int j=low; j<high; j++)
	        {
	            // If current element is smaller than or
	            // equal to pivot
	            if (list[j].compareTo(pivot) <= 1)
	            {
	                i++;
	                swap(i, j);
	            }
	        }
	 
	        // swap arr[i+1] and arr[high] (or pivot)
	        
	        swap(i+1, high);
	 
	        return i+1;
	    }

	public void quickSortRecursively(int low, int high) {
		if (low < high)
        {
            
            int piv = recPartition(low, high);
 
            // Recursively sort elements before
            // partition and after partition
            quickSortRecursively(low, piv-1);
            quickSortRecursively(piv+1, high);
        }
	}

	public void insertionSort() {
		 int n = size;
	        for (int i=1; i<n; ++i)
	        {
	            Comparable key = list[i];
	            int j = i-1;
	            while (j>=0 && (list[j].compareTo(key) >1))
	            {
	                list[j+1] = list[j];
	                j = j-1;
	            }
	            list[j+1] = key;
	        }

	}

	public void bubbleSort() {
		int n = size;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n-i; j++)
                if (list[j].compareTo(list[j+1]) > 1)
                {
                    swap(j, j+1);
                }
	}

	public void bucketSort() {

	}
	
	public Comparable getMax() {
		Comparable max = list[0];
		for(int i = 0; i<=size; i++) {
			if(list[i].compareTo(max)> 1) {
				max = list[i];
			}
		}
		return max;
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
