//package leetcode;

//Runtime: 217 ms
public class Numberof1Bits_191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numberof1Bits_191 test=new Numberof1Bits_191();
		System.out.println(Integer.toBinaryString(-11));
		System.out.println(test.hammingWeight(-11));
	}

	public int hammingWeight(int n) {
		
		String s=Integer.toBinaryString(n);
		int count=0;
		for(char c : s.toCharArray()){
			if(c=='1'){
				count++;
			}
		}
		return count;
	}
}

