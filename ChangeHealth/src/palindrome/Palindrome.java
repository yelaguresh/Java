package palindrome;

public class Palindrome {
	 public boolean checkPalindrome(String inputString)
	    {
	        String str = inputString.replaceAll("\\s+", "").toLowerCase();
	        char[] charArray = str.toCharArray();
	        int forward = 0;
	        int backward = charArray.length - 1;
	        while (forward <= backward)
	        {
	            if(charArray[forward] != charArray[backward])
	            {
	                return false;
	            }
	            forward++;
	            backward--;
	        }
	         return true;
	    }
}
