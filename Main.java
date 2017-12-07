import java.util.Random;

import Lab5.BinarySearchTree;

public class Main {
	public static final void main(String args[]) {

		// Begin tree sort
		int[] arr = new int[50000];

		// Populating the arr array with random numbers
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}

		// Building a tree with arr array
		BinarySearchTree bst = new BinarySearchTree(new Integer(arr[0]));
		for (int i = 1; i < arr.length; i++) {
			bst.insert(bst.root, new Integer(arr[i]));
		}

		// Tree sort test
		System.out.println("Tree sort elements in Increasing Order: ");
		bst.inOrderTreeSort(bst.root);

		// END TREE SORT

		Random rand = new Random();
		ListArrayBased big = new ListArrayBased(500000);
		ListArrayBased small = new ListArrayBased(20);
		for (int i = 0; i < 500000; i++) {
			big.add(rand.nextInt(99999));
		}
		for (int i = 0; i < 20; i++) {
			small.add(rand.nextInt(30));
		}
		// big.mergeSort(0, big.size()-1);
		// small.mergeSort(0, small.size()-1);
		// Merge Sort Works well for all sizes
		// small.bubbleSort();
		// big.bubbleSort();
		// Bubble Sort works only for smaller arrays
		// small.heapSort();
		// big.heapSort();
		// Heap Sort works well for all sizes
		// big.quickSortRecursively(0, big.size() -1);
		// recursive quick sort works for all sizes
		// small.quickSortIteratively();
		// iterative quick sort works only for smaller arrays
		for (int i = 0; i < small.size(); i++) {
			System.out.println(small.get(i));
		}
	}

}
