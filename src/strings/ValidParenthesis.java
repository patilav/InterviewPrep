package strings;

import java.util.Stack;

public class ValidParenthesis {
	public static boolean isValidParenthesis(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
				stack.pop();
			else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
				stack.pop();
			else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
				stack.pop();
			else
				// Invalid char so skip;
				continue;
		}
		return stack.empty();
	}

	public static void main(String args[]) {
		String s = "[b]{(((a)(b)))}";
		System.out.println(isValidParenthesis(s));
	}
}
