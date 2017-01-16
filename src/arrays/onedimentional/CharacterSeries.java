package arrays.onedimentional;

public class CharacterSeries {

	public static int[] generateSeries() {
		// 26 letters
		int[] seriesNumbers = new int[26];
		// A to Z-> 65 to 90

		// add value of A
		seriesNumbers[0] = 1;
		// generate series
		for (int i = 1; i < 26; i++) {
			int prevNum = seriesNumbers[i - 1];
			int currentNum = (prevNum * 2) + i + 1;
			seriesNumbers[i] = currentNum;
		}

		return seriesNumbers;
	}
	
	public static void printSum(String s){
		if(s==null && s.isEmpty()){
			return;
		}
		int[] seriesNumbers = generateSeries();
		long sum = 0;
		for(int i=0; i< s.length(); i++){
			char c = s.charAt(i);
			
			if(c<65 || c>90){
				//invalid character
				return;
			}
			int value = seriesNumbers[c%65];
			sum = sum + value;
		}
		System.out.println(sum);
	}
	
	
	public static void printSum1(String s){
		if(s==null){
			return;
		}
		long sum = 0;
		for(int i=0; i< s.length(); i++){
			char c = s.charAt(i);
			
			if(c<65 || c>90){
				//invalid character
				return;
			}
			int value = computeValue(c);
			sum = sum + value;
		}
		System.out.println(sum);
	}
	
	public static int computeValue(char c){
		
		int num = (c % 65) + 1;
		if(num == 1){
			return 1;
		}
		int prevNum = 1;
		int currentNum = 0;
		for (int i = 1; i < num; i++) {
			currentNum = (prevNum * 2) + i + 1;
			prevNum = currentNum;
		}
		
		return currentNum;
	}

	public static void main(String[] args) {
		int[] seriesNumbers = generateSeries();

		for (int i : seriesNumbers) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nPrinting sum");
		printSum1("GREP");
	}
}
