
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
			if(leftArray[i].compareTo(rightArray[j]) <= 0) {
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
			if(list[firstUnknown].compareTo(p) <0) {
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
		for(int i = 0; i<size-1; i++)
		partition(i, size-1);
	}
	
	int recPartition(int low, int high)
	    {
	        Comparable pivot = list[high]; 
	        int i = low-1; // index of smaller element
	        for (int j=low; j<high; j++)
	        {
	            // If current element is smaller than or
	            // equal to pivot
	            if (list[j].compareTo(pivot) <= 0)
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
	            while (j>=0 && (list[j].compareTo(key) >0))
	            {
	                list[j+1] = list[j];
	                j = j-1;
	            }
	            list[j+1] = key;
	        }

	}

	public void bubbleSort() {
		int n = size;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list[j].compareTo(list[j+1]) > 0)
                {
                    swap(j, j+1);
                }
	}

	public void bucketSort() {

	}
	
	public Comparable getMax() {
		Comparable max = list[0];
		for(int i = 0; i<=size; i++) {
			if(list[i].compareTo(max)> 0) {
				max = list[i];
			}
		}
		return max;
	}

	public void radixSort() {
		
	}
	void heapify(Comparable arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l].compareTo(arr[largest]) >0)
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            swap(i, largest);
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	public void heapSort() {
		 int n = size;
		 
	        // Build heap (rearrange array)
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(list, n, i);
	 
	        // One by one extract an element from heap
	        for (int i=n-1; i>=0; i--)
	        {
	            // Move current root to end
	            swap(i, 0);
	 
	            // call max heapify on the reduced heap
	            heapify(list, i, 0);
	        }
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
		if(size == list.length) {
			add(size+1, E);
			return true;
		}
		else{list[size] = E;
		size++;
		return true;
	}
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
			size++;
			return true;
			
		} else {
			return true;
		}
	}

	// Done
	public int size() {
		return size;}

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
		Comparable temp = list[position1];
		list[position1] = list[position2];
		 list[position2] = temp;
		return true;

	}

	@Override
	public boolean shift(int positions) {
		// TODO Auto-generated method stub
		return false;
	}
}

