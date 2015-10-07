package leetcode;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		int temp;
		
		//安全性检查
		if(nums==null||k<0)
			return;
		for (int i = 0; i < k; i++) {
			temp = nums[len-1];
			for (int j = len-1 ; j >0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = temp;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		RotateArray rota = new RotateArray();
		rota.rotate(array, 2);
	}
}
