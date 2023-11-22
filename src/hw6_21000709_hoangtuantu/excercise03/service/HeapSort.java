package hw6_21000709_hoangtuantu.excercise03.service;

public class HeapSort <T extends Comparable<T>> implements Sort<T> {
	@Override
	public void sort(T[] numbers) {
		int n = numbers.length;

		// Build max heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(numbers, n, i);
		}

		// Extract elements from heap one by one
		for (int i = n - 1; i > 0; i--) {
			// Swap the root (maximum element) with the last element
			T temp = numbers[0];
			numbers[0] = numbers[i];
			numbers[i] = temp;

			// Call max heapify on the reduced heap
			heapify(numbers, i, 0);
		}
	}

	private void heapify(T[] array, int n, int i) {
		int largest = i; // Initialize largest as root
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;

		// If left child is larger than root
		if (leftChild < n && array[leftChild].compareTo(array[largest]) > 0) {
			largest = leftChild;
		}

		// If right child is larger than largest so far
		if (rightChild < n && array[rightChild].compareTo(array[largest]) > 0)  {
			largest = rightChild;
		}

		// If largest is not the root
		if (largest != i) {
			T swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(array, n, largest);
		}
	}
}
