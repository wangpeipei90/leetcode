//package leetcode;

//Runtime: 341 ms
import java.util.HashMap;

public class IsomorphicStrings_205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsomorphicStrings_205 test=new IsomorphicStrings_205();
		System.out.println(test.isIsomorphic("egg","add"));
		System.out.println(test.isIsomorphic("foo","bar"));
		System.out.println(test.isIsomorphic("paper","title"));

		System.out.println(test.isIsomorphic("ab","aa"));
		System.out.println(test.isIsomorphic("aa","bb"));

	}

	public boolean isIsomorphic(String s, String t) {
		if(s==null&t==null){
			return true;
		}
		
		if(s.length()!=t.length()){
			return false;
		}
		
		HashMap<Character,Character> map=new HashMap<Character,Character>();
		
		for(int i=0,j=0;i<s.length()&&j<t.length();i++,j++){
			char key=s.charAt(i);
			char value=t.charAt(j);
			
			if(map.containsKey(key)&&value!=map.get(key)){
				return false;
			}else if(!map.containsKey(key)&&!map.containsValue(value)){
				map.put(key, value);
			}else if(!map.containsKey(key)&&map.containsValue(value)){
				return false;
			}
			
		}
		return true;
	}

}

