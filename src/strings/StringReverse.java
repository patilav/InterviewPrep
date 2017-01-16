package strings;

public class StringReverse {

	public static String reverseRecursive(String s){
		if(s == null || s.length()<=1){
			return s;
		}
		
		return s.substring(1)+ s.charAt(0);
	}
	
	public static String reverseNonRecursive(String s){
		if(s == null || s.length()<=1){
			return s;
		}
		
		int start=0;
		int end=s.length()-1;
		char[] sArray = s.toCharArray();
		//middle char will not move
		while(start<end){
			sArray[end] = s.charAt(start);
			sArray[start] = s.charAt(end);
			start++;
			end--;
		}
		
		return String.valueOf(sArray);
	}
	
	public static void main(String args[]){
		System.out.println(reverseNonRecursive("abcdabc"));
	}
}
