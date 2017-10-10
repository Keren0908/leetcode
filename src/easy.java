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
		String re = "";
		int n = strs.length;
		if (n == 0)
			return re;
		int min_length = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (strs[i].length() < min_length)
				min_length = strs[i].length();
		}

		int d = 0;

		while (d < min_length) {
			int j = 1;
			while (j < n) {
				if (strs[j - 1].charAt(d) == strs[j].charAt(d)) {
					j++;
					if (j == n - 1) {
						re = re + strs[j].charAt(d);
						d++;
					}
				} else {
					return re;
				}
			}
		}
		return re;
	}

	public static String longestCommonPrefix(String[] strs) {
		String re = "";
		int n = strs.length;
		if (n == 0)
			return re;
		if (n == 1)
			return strs[0];

		re = strs[0];
		int i = 1;
		while (i < n) {
			while (strs[i].indexOf(re) != 0)
				re = re.substring(0, re.length() - 1);
			i++;
		}
		return re;

	}

	// 20.Valid Parentheses
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();

	}

	// 21.Merge Two Sorted List

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode newhead;
		if (l1.val < l2.val) {
			newhead = l1;
			newhead.next = mergeTwoLists(l1.next, l2);
		} else {
			newhead = l2;
			newhead.next = mergeTwoLists(l1, l2.next);
		}

		return newhead;
	}

	// 26.remove duplicates from sorted array
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return nums.length;

		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != nums[i])
				nums[++i] = nums[j];
		}
		return i + 1;
	}

	public static int removeElement(int[] nums, int val) {
		int n = nums.length;
		if (n == 0)
			return n;

		int i = n - 1;
		int j = 0;
		while (j < i) {
			while (i > 0 && nums[i] == val)
				i--;

			if (nums[j] == val) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				while (i >= 0 && nums[i] == val)
					i--;
			}
			j++;
		}
		return i + 1;

	}

	// 28.Implement strStr()
	public static int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);

	}

	// 35.Search Insert Position
	public static int searchInsert(int[] nums, int target) {
		int i = 0;
		while (i < nums.length && target > nums[i])
			i++;
		return i;

	}

	// 38.count and say
	public static String countAndSay(int n) {

		int i = 0;
		String re="";
		String s="1";
		while (i < n) {
			re=s;
			s="";
			int count = 0;
			char num = re.charAt(0);

			for (int j = 0; j < re.length(); j++) {
				if (re.charAt(j) == num)
					count++;
				else {
					s = s + Integer.toString(count) + num;
					num = re.charAt(j);
					count = 1;
				}
			}
			s=s+Integer.toString(count)+num;
			i++;
		}
		return re;
	}
	//53.Maximum Subarray
	public static int maxSubArray(int[] nums) {
		int n=nums.length;
		int max=nums[0];
		int alt=nums[0];
		for(int i=0;i<n;i++) {
			alt=Math.max(alt+nums[i], nums[i]);
			max=Math.max(max, alt);
		}
		return max;
		
		
	}
	
	//58.Length of Last Word
	public static int LengthOfLastWord_1(String s) {
		if(s.length()==0)
			return 0;
		int len=0;
		int ind=s.length()-1;
		while(ind>=0) {
			while(ind>=0 && s.charAt(ind)==' ')
				ind--;
			while(ind>=0 && s.charAt(ind)!=' ') {
				ind--;
				len++;
			}
			break;
		}
		return len;
				
			
		}
	public static int LengthOfLastWord(String s) {
		return s.trim().length()-s.trim().lastIndexOf(' ')-1;
	}
	
	//66.plus one
	public static int[] plusOne_error(int[] digits) {
		String digit="";
		for(int i=0;i<digits.length;i++) {
			digit=digit+digits[i];
		}
		String d=Long.toString(Long.parseLong(digit)+1);
		int[] re= new int[d.length()];
		for(int j=0;j<d.length();j++) {
			re[j]=Integer.parseInt(String.valueOf(d.charAt(j)));
		
		}
		
		return re;
		
		
	}
	
	public static int[] plusOne(int[] digits) {
		int n=digits.length;
		
		int remainder=(digits[n-1]+1)%10;
		int quotient=(digits[n-1]+1)/10;
		digits[n-1]=remainder;
		
		for(int i=n-2;i>=0;i--) {
			digits[i]+=quotient;
			remainder=digits[i]%10;
			quotient=digits[i]/10;
			digits[i]=remainder;
		}
		if(quotient==0)
			return digits;
		else {
			int[] new_digits=new int[n+1];
			for(int i=0;i<n;i++)
				new_digits[i+1]=digits[i];
			new_digits[0]=quotient;
			return new_digits;
		}
			
		
		
	}
	public static int[] plusOne_1(int[] digits) {
		int n=digits.length;
		for(int i=n-1;i>=0;i--) {
			if(digits[i]<9) {
				digits[i]++;
				return digits;
			}
			digits[i]=0;
			
		}
		int[] new_digits=new int[n+1];
		new_digits[0]=1;
		return new_digits;
		
	}
	
		
	

	public static void main(String[] args) {
		/*
		 * int z = 1234321; System.out.println(isPalindrome(z));
		 * 
		 * String s = "VIII"; System.out.println(romanToInt(s));
		 * 
		 * String[] aa= {"asdee","asecvbn","asloiiiiii"}; String[] bb=
		 * {"abab","aba",""}; System.out.println("ss="+longestCommonPrefix(bb));
		 * //System.out.println("".indexOf("ab"));
		 */

		// String a="(){}[]";
		// System.out.println(isValid(a));
		// int[] nums= {1,3,5,6};
		int[] a= {9,8,7,6,5,4,3,2,1,0};
		
		int[] b=plusOne_1(a);
		for(int i:b)
			System.out.println(i);

	}

}
