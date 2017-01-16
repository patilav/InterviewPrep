package strings;

import java.util.HashSet;

public class MaximumLengthPalindrome {

	public static int getPalindromeLength(String s) {

		if (s == null) {
			return 0;
		}

		if (s.length() == 1) {
			return 1;
		}
		
		int n = s.length();

		HashSet<Character> charBag = new HashSet<>();
		int pairsFound = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (charBag.contains(c)) {
				charBag.remove(c);
				pairsFound++;
			} else {
				charBag.add(c);
			}
		}
		
		int palindromeStringLength = 0;
		if(charBag.size()>0){	//this means we have odd chars in the set
			palindromeStringLength = pairsFound*2 + 1;	//select 1 random char from bag;
		} else{
			palindromeStringLength = pairsFound *2;
		}
		return palindromeStringLength;
	}
	
	public static void main(String args[]){
		String s = "aabcbcbdcc";
		System.out.println(getPalindromeLength("b"));
		
	}
}
