package leetcode;

public class RemoveDuplicatesfromSortedArray {
	public static int removeDuplicatesNaive(int[] A) {
		// 安全性判断
		if (A.length < 2)
			return A.length;
		int index = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[index-1] != A[i])
				A[index++] = A[i];
		}
		return index;
	}

	public static int removeDuplicatesNaive1(int[] A) {
		// 安全性判断
		if (A.length < 2)
			return A.length;
		int index = 2;
		for (int i = 2; i < A.length; i++) {
			if (A[index - 2] != A[i])
				A[index++] = A[i];
		}
		return index;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 3, 3, 4, 5, 5, 7 };
		int count = 0;
		int count1 = 0;
		count = removeDuplicatesNaive1(a);
		count1 = removeDuplicatesNaive(a);
		System.out.println(count);
		System.out.println(count1);
	}

}
