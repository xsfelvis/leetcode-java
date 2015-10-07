package leetcode;

import java.util.Scanner;

public class ReverseInteger {
	/*public int reverse(int x) {
		// 数字转字符处理
		long result = 0;
		int flag = 1;// x正负判断
		StringBuilder sb = new StringBuilder();
		String temp = String.valueOf(Math.abs(x));
		if (x < 0)
			flag = -1;

		for (int i = temp.length() - 1; i >= 0; i--) {
			sb.append(temp.charAt(i));
		}
		result = Long.valueOf(sb.toString());
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		
		return (int) (result * flag);
	}*/
	
	  public int reverse1(int x) {
	    	long reverse = 0;
	        
	        while(x != 0){
	        	reverse = reverse * 10 + x % 10;
	        	if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
	        		return 0;
	        	x = x / 10;
	        }
	        return (int)reverse;
	    }

	public static void main(String[] args) {
		ReverseInteger rs = new ReverseInteger();
		Scanner sn =new Scanner(System.in);
		int in = sn.nextInt();
		int out;
		out = rs.reverse1(in);
		System.out.println(out);
	}
}
