package strings;

public class LongestPalindromicSubsequence {
	public static String checkPalindromeFromMiddle(String s, int start, int end) {

		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}

		return s.substring(start + 1, end);
	}

	public static boolean checkPalindromeFromStart(String s, int start, int end) {

		while (start >= 0 && end < s.length() && start < end) {

			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}
	
	public static void checkLongestPalindrome(String s){
		
		if(s == null){
			return;
		}
		
		if(s.length() == 0){
			return;
		}
		String longest = "";
		for(int i = 0; i< s.length();i++){
			int start = i;
			int end = s.length()-1;
			boolean found = false;
			while(start<end){
				found = checkPalindromeFromStart(s, start, end);
				if(found){
					if(longest.length() < (end - start+1)){
						longest = s.substring(start, end+1);
					}
					break;
				}
				end--;
			}
			if(found){
				break;
			}
		}
		
		System.out.println(longest);
		
	}
	
	public static void main(String args[]){
		String s =longestPalindrome("dabclcbalkkl");
		System.out.println(s);
	}
	
	public static String longestPalindrome(String s) {
		int longestLength = Integer.MIN_VALUE;
        String longestPalindrome = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length()-1; j >= 0 && j != i; j--){
            	if((j-1)< longestLength){
            		break;
            	}
                if(isPalindrome(s.substring(i,j+1))){
                    if(s.substring(i, j+1).length()>longestPalindrome.length()){
                        longestPalindrome = s.substring(i, j+1);
                        longestLength = longestPalindrome.length();
                    }
                }
            }
        }
        return longestPalindrome;
    }
    public static boolean isPalindrome(String s){
        int end = s.length()-1;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(end)){
                return false;
            }
            end--;
        }
        return true;
    }
}
