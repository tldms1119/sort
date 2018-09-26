package com.sieun.sort;

public class HeapSort {

	// heap 구조를 만드는 시간 복잡도 = O(n)
	public static void main(String[] args) {
		int[] heap = { 12, 5, 4, 7, 9, 3, 5, 10 };
		
		heapSort(heap);
		
		for(int num : heap) {
			System.out.print(num + " ");
		}
	}
	
	// 크기를 하나씩 줄여나가면서 다시 Heapify 하는 시간 복잡도 = O(log n)
	// Heapify를 원소의 개수만큼 실행하게 되니까 sorting 하는데 걸리는 총 시간 복잡도 = O(n log n) 
	public static void heapSort(int[] heap) {
		// 최대 힙 구조 생성(상향식)
		for (int i = 1; i < heap.length; i++) {
			int c = i;
			do {
				int root = (c - 1) / 2; // 특정 원소의 부모 위치 = root
				if (heap[root] < heap[c]) {
					int temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c = root;
			} while (c != 0);
		}

		// 크기를 줄여가며 반복적으로 힙을 구성
		for (int i = heap.length - 1; i >= 0; i--) {
			int temp = heap[0]; // 최대값과 맨 끝 값 교체
			heap[0] = heap[i];
			heap[i] = temp;
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				// 자식 중에 더 큰 값 선택
				if (c < i - 1 && heap[c] < heap[c + 1]) { // c 크기 검사를 먼저 해줌으로써 out of bounds 방지
					c++;
				}
				// root보다 자식이 더 크면 교체
				if (c < i && heap[root] < heap[c]) {
					temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				root = c;
			} while (c < i);
		}

	}
}
