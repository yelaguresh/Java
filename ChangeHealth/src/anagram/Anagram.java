package anagram;

import java.util.Arrays;

public class Anagram {

	public boolean checkAnagram(String str1, String str2) {
		String str12 = str1.replaceAll("\\s", "").toLowerCase();
		String str22 = str2.replaceAll("\\s", "").toLowerCase();
		boolean status=true;
		if(str12.length()!=str22.length())
		{
			status=false;
		}
		else {
			char[] charArray1=str12.toLowerCase().toCharArray();
			char[] charArray2=str22.toLowerCase().toCharArray();
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			status=Arrays.equals(charArray1, charArray2);
		}
		if(status)
		{
			return status;
			
		}
		else {
			return status;
		}
	}

}
