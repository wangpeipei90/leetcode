//package leetcode;

import java.util.ArrayList;

//Runtime: 383 ms
public class HouseRobber_198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber_198 test = new HouseRobber_198();
		int[] nums0 = {};
		int[] nums1 = { 1 };
		int[] nums2 = { 1, 5 };
		int[] nums3 = { 2, 5, 4 };
		int[] nums4 = { 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(test.rob(nums0));
	}

	public int rob(int[] nums) {
		// if(nums.length==0){
		// return 0;
		// }
		// if(nums.length==1){
		// return nums[0];
		// }
		//
		// if(nums.length==2){
		// return Math.max(nums[0], nums[1]);
		// }
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(0, 0);
		if (nums.length > 0) {  /**handle len=0,1,2*/
			array.add(1, nums[0]);
		}
		if (nums.length > 1) {
			array.add(2, Math.max(nums[0], nums[1]));

		}

		// return rob(nums, nums.length);
		// return rob(nums, nums.length, array);
		if (nums.length < 3) {
			return array.get(nums.length);
		}

		int p = 3;
		while (p <= nums.length) {
			int with_last = array.get(p - 2) + nums[p - 1];
			int without_last = array.get(p - 1);
			System.out.println(p + ": with_last: " + with_last);
			System.out.println(p + " without_last: " + without_last);
			array.add(p, Math.max(with_last, without_last));
			p = p + 1;
		}

		return array.get(nums.length);

	}

	/* Status: Time Limit Exceeded */
	private int rob(int[] nums, int len) {
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return nums[0];
		}

		if (len == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int with_last = rob(nums, len - 2) + nums[len - 1];
		int without_last = rob(nums, len - 1);
		System.out.println("with_last: " + with_last);
		System.out.println("without_last: " + without_last);
		return Math.max(with_last, without_last);

	}

	// private int rob(int[] nums, int len, ArrayList<Integer> array) {
	//
	//
	//
	//
	//
	// }

}

