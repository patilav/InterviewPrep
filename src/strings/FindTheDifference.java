package strings;

public class FindTheDifference {

	public static char findTheDifference(String s, String t) {

		if (s.length() >= t.length()) {
			// unequal arrays
			return '\0';
		}

		// Small letters start from 97 to 122
		int present[] = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			present[c % 97] = present[c % 97] + 1;
		}

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (present[c % 97] == 0) {
				return c;
			} else {
				present[c % 97] = present[c % 97] - 1;
			}
		}
		return '\0';
	}

	public static void main(String args[]) {
		String a = "abcd";
		String b = "abcde";

		System.out.println(findTheDifference(a, b));
	}
}
