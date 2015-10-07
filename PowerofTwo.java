package leetcode;

public class PowerofTwo {
	public boolean isPowerOfTwo(int n) {
		if(n==0)
			return false;
		if(n>0&&(n&(n-1))==0){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		PowerofTwo pt = new PowerofTwo();
		boolean flag;
		int in = 4;
		flag = pt.isPowerOfTwo(in);
		System.out.println(flag);
	}

	
}
