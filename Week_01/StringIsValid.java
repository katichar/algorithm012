
思路：最近相关性的问题，可以用stack来解决

时间复杂度 O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if ( cur == '[' || cur == '{' || cur == '(') {
                stack.push(cur);
            }else{
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if ( (cur == ')' && pop == '(') || (cur == ']' && pop == '[') || (cur == '}' && pop == '{') ) {
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }else if(c == '{') {
                stack.push('}');
            }else if(c == '[') {
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
-------------------最优解-国站0s char[]
public class Solution {
	public boolean isValid(String s) {
		char[] stack = new char[s.length()];
		int head = 0;
		for(char c : s.toCharArray()) {
			switch(c) {
				case '{':
				case '[':
				case '(':
					stack[head++] = c;
					break;
				case '}':
					if(head == 0 || stack[--head] != '{') return false;
					break;
				case ')':
					if(head == 0 || stack[--head] != '(') return false;
					break;
				case ']':
					if(head == 0 || stack[--head] != '[') return false;
					break;
			}
		}
		return head == 0;

	}
}
解有效的括号题时，同样的解法，使用char[] stack 和 Stack<Character> 结果果间差2秒
public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int head = 0;
		for(char c : s.toCharArray()) {
			switch(c) {
				case '{':
				case '[':
				case '(':
					stack.push(c);
					break;
				case '}':
					if(stack.isEmpty() || stack.pop() != '{') return false;
					break;
				case ')':
					if(stack.isEmpty() || stack.pop() != '(') return false;
					break;
				case ']':
					if(stack.isEmpty() || stack.pop() != '[') return false;
					break;
			}
		}
		return stack.isEmpty();

	}
}
有效的括号
https://leetcode-cn.com/problems/valid-parentheses/submissions/