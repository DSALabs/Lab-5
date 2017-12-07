import java.util.Random;
public class Main {
	public static final void main(String args[]) {
		
		Random rand = new Random();
		ListArrayBased big = new ListArrayBased(500000);
		ListArrayBased small = new ListArrayBased(20);
		for(int i = 0; i<500000; i++) {
			big.add(rand.nextInt(99999));
		}
		for(int i = 0; i<20; i++) {
			small.add(rand.nextInt(30));
		}
		//big.mergeSort(0, big.size()-1);
		//small.mergeSort(0, small.size()-1);
		//Merge Sort Works well for all sizes
		//small.bubbleSort();
		//big.bubbleSort(); 
		//Bubble Sort works only for smaller arrays
		//small.heapSort();
		//big.heapSort();
		//Heap Sort works well for all sizes
		//big.quickSortRecursively(0, big.size() -1);
		//recursive quick sort works for all sizes
		//small.quickSortIteratively();
		//iterative quick sort works only for smaller arrays
		for(int i = 0; i< small.size(); i++) {
			System.out.println(small.get(i));
		}
	}
	
}
