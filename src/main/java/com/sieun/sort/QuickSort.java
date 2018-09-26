package com.sieun.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] data = {1, 10, 5, 6, 4, 7, 2, 3, 8, 9};		// QuickSort 최악의 케이스(분할이 안됨)
		
		quickSort(data, 0, data.length - 1);
		for(int num : data) {
			System.out.print(num + " ");
		}
	}
	
	// quickSort의 시간 복잡도 = O(n log n)
	// 최악의 경우는 O(n2) 일 수 있음(분할 안되는 경우)
	public static void quickSort(int[] data, int start, int end) {
		if(start >= end) {	// data가 1개
			return;
		}
		
		int pivot = start;
		int i = start + 1;
		int j = end;
		int temp;
		
		while(i <= j) {	// 엇갈리지 않았으면 계속해서 큰값, 작은값 찾기
			while(data[i] <= data[pivot]){
				i++;
				if(i > end)		// out of Bounds Exception 대비
					break;
			}
			while(data[j] >= data[pivot] && j > start){
				j--;
			}
			if(i > j) {	// 엇갈렸으면 J와 pivot 교체 후 while문 밖으로
				temp = data[j];
				data[j] = data[pivot];
				data[pivot] = temp;
			} else {	// 안 엇갈렸으면 i, j 교체
				temp = data[j];
				data[j] = data[i];
				data[i] = temp;				
			}
		}
		
		if(j != 0)
			quickSort(data, start, j - 1);
		if(j != end)
			quickSort(data, j + 1, end);
	}

}
