//package leetcode;

import java.util.HashSet;
//Runtime: 379 ms
public class HappyNumber_202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappyNumber_202 test = new HappyNumber_202();
//		System.out.println(test.isHappy(19));
//		System.out.println(test.isHappy(1));
		System.out.println(test.isHappy(9));
//		System.out.println(test.isHappy(9));
//		System.out.println(test.isHappy(2));
	}
	

	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}

		String digits = null;
		int sum = 0;
		HashSet<Integer> set = new HashSet<Integer>();

		while (!set.contains(n)) {
			set.add(n);
			System.out.println(n);
			digits = String.valueOf(n);
			sum = 0;
			for (char i : digits.toCharArray()) {
				int t=Character.getNumericValue(i);
				sum = sum + t*t;
				//System.out.println(sum);
			}

			n = sum;
		}

		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}

}

