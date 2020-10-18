package Day6;

public class ValidPalindrome {

	//using string buffer
	public boolean isPalindrome(String s) {

		s = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

		StringBuffer sb = new StringBuffer(s);
		String revStr = new String(sb.reverse());

		if(s.equals(revStr)) return true;

		return false;
	}

	//Without using string buffer
	public boolean isPalindrome1(String s) {

		s = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
		char inputCharArray[] = s.toCharArray();
		
		int start_pointer = 0;
		int end_pointer = inputCharArray.length-1;
		
		while(start_pointer<=end_pointer) {
			if(inputCharArray[start_pointer] != inputCharArray[end_pointer]) {
				return false;
			}
			start_pointer++;
			end_pointer--;
		}

		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome palin = new ValidPalindrome();
		//String inputString = "race a car";
		String inputString = "A man, a plan, a canal: Panama";
		System.out.println(palin.isPalindrome(inputString));
		System.out.println(palin.isPalindrome1(inputString));

	}

}
