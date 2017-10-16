import java.util.HashMap;

import java.util.Stack;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

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
		String re = "";
		String s = "1";
		while (i < n) {
			re = s;
			s = "";
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
			s = s + Integer.toString(count) + num;
			i++;
		}
		return re;
	}

	// 53.Maximum Subarray
	public static int maxSubArray(int[] nums) {
		int n = nums.length;
		int max = nums[0];
		int alt = nums[0];
		for (int i = 0; i < n; i++) {
			alt = Math.max(alt + nums[i], nums[i]);
			max = Math.max(max, alt);
		}
		return max;

	}

	// 58.Length of Last Word
	public static int LengthOfLastWord_1(String s) {
		if (s.length() == 0)
			return 0;
		int len = 0;
		int ind = s.length() - 1;
		while (ind >= 0) {
			while (ind >= 0 && s.charAt(ind) == ' ')
				ind--;
			while (ind >= 0 && s.charAt(ind) != ' ') {
				ind--;
				len++;
			}
			break;
		}
		return len;

	}

	public static int LengthOfLastWord(String s) {
		return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
	}

	// 66.plus one
	public static int[] plusOne_error(int[] digits) {
		String digit = "";
		for (int i = 0; i < digits.length; i++) {
			digit = digit + digits[i];
		}
		String d = Long.toString(Long.parseLong(digit) + 1);
		int[] re = new int[d.length()];
		for (int j = 0; j < d.length(); j++) {
			re[j] = Integer.parseInt(String.valueOf(d.charAt(j)));

		}

		return re;

	}

	public static int[] plusOne(int[] digits) {
		int n = digits.length;

		int remainder = (digits[n - 1] + 1) % 10;
		int quotient = (digits[n - 1] + 1) / 10;
		digits[n - 1] = remainder;

		for (int i = n - 2; i >= 0; i--) {
			digits[i] += quotient;
			remainder = digits[i] % 10;
			quotient = digits[i] / 10;
			digits[i] = remainder;
		}
		if (quotient == 0)
			return digits;
		else {
			int[] new_digits = new int[n + 1];
			for (int i = 0; i < n; i++)
				new_digits[i + 1] = digits[i];
			new_digits[0] = quotient;
			return new_digits;
		}

	}

	public static int[] plusOne_1(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;

		}
		int[] new_digits = new int[n + 1];
		new_digits[0] = 1;
		return new_digits;

	}

	// 67.add binary
	public static String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			for (int i = 0; i < b.length() - a.length(); i++)
				a = "0" + a;
		} else if (a.length() > b.length()) {
			for (int i = 0; i < a.length() - b.length(); i++)
				b = "0" + b;
		}
		int[] sa = new int[a.length()];
		int[] sb = new int[b.length()];

		for (int i = 0; i < a.length(); i++) {
			sa[i] = Character.getNumericValue(a.charAt(i));
			sb[i] = Character.getNumericValue(b.charAt(i));
		}

	}

	public static String addBinary_1(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(1);
		return sb.reverse().toString();

	}

	// 83 remove duplicates from sorted list
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;

	}

	public static ListNode deleteDuplicates(ListNode head) {

		ListNode list = head;
		while (list != null) {
			if (list.next == null) {
				break;
			}
			if (list.val == list.next.val)
				list.next = list.next.next;
			else
				list = list.next;
		}
		return head;
	}

	// 88.Merge Sorted Array
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 || j >= 0) {
			if (i < 0)
				nums1[k--] = nums2[j--];
			if (j < 0)
				nums1[k--] = nums1[i--];
			if (i >= 0 && j >= 0)
				nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}

	}

	// 100.Same Tree
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack_p = new Stack<TreeNode>();
		Stack<TreeNode> stack_q = new Stack<TreeNode>();
		stack_p.push(p);
		stack_q.push(q);
		while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
			TreeNode pp = stack_p.pop();
			TreeNode qq = stack_q.pop();
			if (pp.val != qq.val)
				return false;
			if (pp.left != null)
				stack_p.push(pp.left);
			if (qq.left != null)
				stack_q.push(qq.left);
			if (stack_p.size() != stack_q.size())
				return false;
			if (pp.right != null)
				stack_p.push(pp.right);
			if (qq.right != null)
				stack_q.push(qq.right);
			if (stack_p.size() != stack_q.size())
				return false;
		}
		return stack_p.size() == stack_q.size();

	}

	public static boolean isSameTree_1(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val) {
			return isSameTree_1(p.left, q.left) && isSameTree_1(p.right, q.right);
		}
		return true;
	}

	// 101.Symmetric Tree
	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> left = new Stack<TreeNode>();
		Stack<TreeNode> right = new Stack<TreeNode>();
		if (root.left != null)
			left.push(root.left);
		if (root.right != null)
			right.push(root.right);
		while (!left.isEmpty() && !right.isEmpty()) {
			TreeNode l = left.pop();
			TreeNode r = right.pop();
			if (l.val != r.val)
				return false;
			if (l.left != null)
				left.push(l.left);
			if (r.right != null)
				right.push(r.right);
			if (left.size() != right.size())
				return false;
			if (l.right != null)
				left.push(l.right);
			if (r.left != null)
				right.push(r.left);
			if (left.size() != right.size())
				return false;
		}
		return left.size() == right.size();

	}

	// 104.Maximum Depth of Binary Tree
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);

		return l > r ? l + 1 : r + 1;

	}

	// 107.Binary Tree level Order Traversal II
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null)
			return list;
		int nCount = 1;// 记录每一层的node树
		int nDepth = 0;// 记录深度

		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> sublist = new LinkedList<Integer>();
			while (nCount != 0) {
				TreeNode temp = queue.peek();
				sublist.add(queue.poll().val);
				nCount--;
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
			if (nCount == 0) {
				nDepth++;
				nCount = queue.size();
				list.add(0, sublist);

			}
		}
		return list;

	}

	// 108.convert sorted array to binary search tree
	public static TreeNode sortedArrayToBST(int[] nums) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		int n = nums.length;
		if (n == 0)
			return null;
		int i = 1;

		TreeNode root = new TreeNode(nums[0]);

		queue.offer(root);
		while (i < n) {
			TreeNode temp = queue.poll();
			TreeNode left = new TreeNode(nums[i++]);
			temp.left = left;
			queue.offer(left);
			TreeNode right = new TreeNode(nums[i++]);
			temp.right = right;
			queue.offer(right);
		}
		return root;

	}

	// 110.Balanced Binary Tree
	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int lh = NodeHeight(root.left);
		int rh = NodeHeight(root.right);
		if (Math.abs(lh - rh) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);

	}

	public static int NodeHeight(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int lh = NodeHeight(root.left);
		int rh = NodeHeight(root.right);
		return Math.max(lh, rh) + 1;

	}

	// 111.Minimum depth of binary tree

	// dfs depth first search
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int lt = Integer.MAX_VALUE;
		int rt = Integer.MAX_VALUE;
		if (root.left != null)
			lt = minDepth(root.left);
		if (root.right != null)
			rt = minDepth(root.right);
		return Math.min(lt, rt) + 1;
	}

	// bfs breadth first search
	public int minDepth_1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int nCount = 1;
		int nDepth = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			nCount--;

			if (temp.left != null)
				queue.offer(temp.left);
			if (temp.right != null)
				queue.offer(temp.right);

			if (temp.left == null && temp.right == null) {
				nDepth++;
				return nDepth;
			}

			if (nCount == 0) {
				nCount = queue.size();
				nDepth++;
			}
		}
		return nDepth;

	}
	
	//665.Non-decreasing array
	public static boolean checkPossibility(int[] nums) {
		int n=nums.length;
		if(n==0 || n==1 || n==2) return true;
		int count=0;
		for(int i=0;i+1<n;i++) {
			if(nums[i]>nums[i+1]) {
				count++;
				if(i>0 && nums[i+1]>nums[i-1]) nums[i]=nums[i+1];
				else nums[i+1]=nums[i];
			}
		}
		return count<=1;
	
		
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
		int[] nums= {5,4,2,3,3};
		System.out.println(checkPossibility(nums));

	}

}
