package leetcode;

import java.util.HashSet;
import java.util.Set;

/*主要通过hash集合判断是否出现循环则退出*/
public class IsHappy {
	public boolean isHappy(int n) {
		if (n == 1)
			return true;
		if (n == 0)
			return false;
		long ln = n;
		Set<Long> set = new HashSet<Long>();
		while(ln<Integer.MAX_VALUE){
			//如果发现循环数
			if(set.contains(ln))
				return false;
			else
				set.add( ln);
			ln = digitaAquare(ln);
			if(ln==1)
				return true;
		}

		return false;

	}

	private long digitaAquare(long ln) {
		//拆分数字和是否为0
		long sum =0;
		while(ln!=0){
			sum+=Math.pow(ln%10, 2);
			ln/=10;
		}
		return sum;
	}
	public static void main(String[] args) {
		int n = 2;
		IsHappy is =new IsHappy();
		
		System.out.println(is.isHappy(n));
		
	}
}
