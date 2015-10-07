package leetcode;

public class Numberof1Bits {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		if(n==0)
			return 0;
		int count = 0;
		while(n!=0){
			n = n&(n-1);
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Numberof1Bits nb = new Numberof1Bits();
		int in = 0;
		int out;
		out = nb.hammingWeight(in);
		System.out.println(out);
	}
}
