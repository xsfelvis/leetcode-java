package leetcode;

public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
		// 安全性检查
		if (A == null)
			return -1;
		int first = 0;
		int end = A.length;
		int mid = 0;
		while (first != end) {
			mid = (first + end) / 2;
			if (A[mid] == target)
				return mid;
			if (A[first] <= A[mid]) {
				if (A[first] <= target && target < A[mid])
					end = mid;
				else
					first = mid + 1;
			} else {
				if (A[mid] < target && target <= A[end - 1])
					first = mid + 1;
				else
					end = mid;

			}
		}
		return -1;
	}
}
