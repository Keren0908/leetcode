import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class easy {

	public int[] twoSum(int[] nums, int target) {
		int[] indices = new int[2];
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (hash.containsKey(diff)) {
				indices[0] = hash.get(diff);
				indices[1] = i;
			} else {
				hash.put(nums[i], i);
			}
		}
		return indices;
	}

	public int reverse(int x) {
		int revint = 0;

		while (x != 0) {
			int tail = x % 10;
			int textrevint = revint * 10 + tail;
			if ((textrevint - tail) / 10 != revint)
				return 0;
			revint = textrevint;
			x = x / 10;

		}
		return revint;

	}

	// 9.palindrome number
	public static boolean isPalindrome(int x) {

		if (x < 0)
			return false;

		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		System.out.println(x + " " + rev);
		return (x == rev || x == rev / 10);

	}

	// 13 roman numerals to integer
	public static int romanToInt(String s) {
		int[] nums = new int[s.length()];
		// HashMap<Character,Integer> hash=new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'I':
				// hash.put('I', 1);
				nums[i] = 1;
				break;
			case 'V':
				nums[i] = 5;
				// hash.put('V', 5);
				break;
			case 'X':
				// hash.put('x',10);
				nums[i] = 10;
				break;
			case 'L':
				nums[i] = 50;
				// hash.put('L',50);
				break;
			case 'C':
				// hash.put('C', 100);
				nums[i] = 100;
				break;
			case 'D':
				// hash.put('D', 500);
				nums[i] = 500;
				break;
			case 'M':
				// hash.put('M', 1000);
				nums[i] = 1000;
				break;
			}
		}
		int sum = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				sum = sum - nums[i];
			else
				sum = sum + nums[i];
		}
		return sum + nums[nums.length - 1];

	}

	// 14.Longest Common Prefix
	public static String longestCommonPrefix_1(String[] strs) {
		String re="";
		int n=strs.length;
		if(n==0)
			return re;
		int min_length=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(strs[i].length()<min_length)
				min_length=strs[i].length();
		}
			
		int d=0;
		
		while(d<min_length) {
			int j=1;
			while(j<n) {
				if(strs[j-1].charAt(d)==strs[j].charAt(d)) {
					j++;
					if(j==n-1) {
						re=re+strs[j].charAt(d);
						d++;
					}
				}
				else {
					return re;
				}
			}
		}
		return re;
	}
	public static String longestCommonPrefix(String[] strs) {
		String re="";
		int n=strs.length;
		if(n==0)
			return re;
		if(n==1) 
			return strs[0];
		
		re = strs[0];
		int i=1;
		while(i<n) {
			while(strs[i].indexOf(re)!=0)
				re=re.substring(0, re.length()-1);
			i++;
		}
		return re;
		
	}
	
	//20.Valid Parentheses
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c:s.toCharArray()) {
			if(c=='(')
				stack.push(')');
			else if(c=='{')
				stack.push('}');
			else if(c=='[')
				stack.push(']');
			else if(stack.isEmpty()||stack.pop()!=c)
				return false;
		}
		return stack.isEmpty();
		
	}
	


	public static void main(String[] args) {
		/*int z = 1234321;
		System.out.println(isPalindrome(z));

		String s = "VIII";
		System.out.println(romanToInt(s));
		
		String[] aa= {"asdee","asecvbn","asloiiiiii"};
		String[] bb= {"abab","aba",""};
		System.out.println("ss="+longestCommonPrefix(bb));
		//System.out.println("".indexOf("ab"));*/
		
		String a="(){}[]";
		System.out.println(isValid(a));
		

	}

}
