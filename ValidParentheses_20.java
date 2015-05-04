//package leetcode;

import java.util.Stack;

public class ValidParentheses_20 {

	public boolean isValid(String s) {
		//runtime: 259ms
		if (s == null || s.isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		/**
		 * add stack.isEmpty() because Runtime Error Message: Line 22:
		 * java.util.EmptyStackException Last executed input: "]"
		 */

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}

			} else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}

			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isValid2(String s) {
		//the method of using points could not work, using stack is the correct solution
		/**
		 * Time Limit Exceeded
		 * Submitted: 1 minute ago
		 * Last executed input:	"([)]"---p and q do not change
		 * 
		 * Input:	"[({(())}[()])]"
		 * Output:	false
		 * Expected:	true
		 */
		if (s == null || s.isEmpty()) {
			return true;
		}else if(s.length()%2>0){
			return false;
		}
		int p = 0;
		int q = s.length() - 1;
		if (p == q) {
			return false;
		}
		
		while (p+1 < q) {
			char start = s.charAt(p);
			char end = s.charAt(q);
			if((start=='{'&&end=='}')||(start=='['&&end==']')||(start=='('&&end==')')){
				p=p+1;
				q=q-1;
				continue;
			}
			
			char next_start = s.charAt(p+1);
			char next_end = s.charAt(q-1);
			switch (start) {
			case '{':
				if (next_start== '}') {
					p=p+2;	
				}
				break;
			case '(':
				if (next_start == ')') {
					p=p+2;
				}
				break;
			case '[':
				if (next_start == ']') {
					p=p+2;
				}
				break;
			default:
				return false;
			}
			
			switch (end) {
			case '}':
				if (next_end== '{') {
					q=q-2;
				}
				break;
			case ')':
				if (next_end == '(') {
					q=q-2;
				}
				break;
			case ']':
				if (next_end == '[') {
					q=q-2;
				}
				break;
			default:
				return false;
			}
			
			if(start==s.charAt(p)&&end==s.charAt(q)){
				return false;
			}
			
		}
		
		if(p+1==q&&((s.charAt(p)=='{'&&s.charAt(q)=='}')||(s.charAt(p)=='('&&s.charAt(q)==')')||(s.charAt(p)=='['&&s.charAt(q)==']'))){
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses_20 test = new ValidParentheses_20();
		System.out.println(test.isValid(""));
		System.out.println(test.isValid2(""));
		System.out.println("1");
		
		System.out.println(test.isValid("["));
		System.out.println(test.isValid2("["));
		System.out.println("2");
		
		System.out.println(test.isValid("]"));
		System.out.println(test.isValid2("]"));
		System.out.println("3");
		
		System.out.println(test.isValid("[8]"));
		System.out.println(test.isValid2("[8]"));
		System.out.println("4");
		
		System.out.println(test.isValid("[](){}"));
		System.out.println(test.isValid2("[](){}"));
		System.out.println("5");
		
		System.out.println(test.isValid("[{}"));
		System.out.println(test.isValid2("[{}"));
		System.out.println("6");
		
		System.out.println(test.isValid("[{}]()"));
		System.out.println(test.isValid2("[{}]()"));
		System.out.println("7");
		
		System.out.println(test.isValid("[}]"));
		System.out.println(test.isValid2("[}]"));
		System.out.println("8");
		
		System.out.println(test.isValid("[}}"));
		System.out.println(test.isValid2("[}}"));
		System.out.println("9");
		
		System.out.println(test.isValid("[[}"));
		System.out.println(test.isValid2("[[}"));
		System.out.println("10");
		
		System.out.println(test.isValid("([)]"));
		System.out.println(test.isValid2("([)]"));
		System.out.println("11");
		
		
		System.out.println(test.isValid("[({(())}[()])]"));
		System.out.println(test.isValid2("[({(())}[()])]"));
		System.out.println("12");
		
		
		
	}

}

