//package leetcode;

import java.util.Stack;

public class ValidParentheses_20 {

	public boolean isValid(String s) {
		if(s==null ||s.isEmpty()){
			return true;
		}
		Stack<Character> stack=new Stack<Character>();
		/**
		 * add stack.isEmpty() because
		 * Runtime Error Message:	Line 22: java.util.EmptyStackException
		 * 		Last executed input:	"]"
		 */
		
		for (char c: s.toCharArray()){
			if(c=='('||c=='{'||c=='['){
				stack.push(c);
			}else if(c==')'){
				if(stack.isEmpty()||stack.pop()!='('){
					return false;
				}
				
			}else if(c=='}'){
				if(stack.isEmpty()||stack.pop()!='{'){
					return false;
				}
			
			}else if(c==']'){
				if(stack.isEmpty()||stack.pop()!='['){
					return false;
				}
			}else{
				return false;
			}
		}
		if(stack.isEmpty()){
			return true;
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses_20 test=new ValidParentheses_20();
		System.out.println(test.isValid(""));
		System.out.println(test.isValid("["));
		System.out.println(test.isValid("]"));
		System.out.println(test.isValid("[8]"));
		System.out.println(test.isValid("[](){}"));
		System.out.println(test.isValid("[{}"));
		System.out.println(test.isValid("[{}]()"));
		System.out.println(test.isValid("[}]"));
	}

}


