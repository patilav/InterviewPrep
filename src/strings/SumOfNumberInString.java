package strings;

public class SumOfNumberInString {

	public static int sumTheNumbers(String s) {
		int sum = 0;
		if (s == null || s.isEmpty()) {
			return sum;
		}

		int currentValue = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				if (currentValue > 0) {
					currentValue = currentValue * 10 + Character.getNumericValue(c);
				} else {
					currentValue = Character.getNumericValue(c);
				}
			} else {
				sum = sum + currentValue;
				currentValue = 0;
			}
		}
		return sum + currentValue;
	}

	public static void main(String args[]) {
		System.out.println(sumTheNumbers("aa11b3"));
	}
}
