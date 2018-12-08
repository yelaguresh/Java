package palindrome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckPalindromeTest {
Palindrome palindrome=new Palindrome();
	@Test
	public void test1() {
		String input = "A   Santa         at Nasa";
        assertTrue(palindrome.checkPalindrome(input));
	}
	@Test
	public void invalidPalindromeTest() {
		String input = "A D";
        assertFalse(palindrome.checkPalindrome(input));
	}
	@Test
    public void invalidPalindromeTest1() throws Exception {

        String input = "I am a tester";

        assertFalse(palindrome.checkPalindrome(input));
    }
	@Test
    public void alphaNumericPalindromeTest() throws Exception {

        String input = "Air 2 an a2ria";

        assertTrue(palindrome.checkPalindrome(input));
    }

    @Test
    public void validPalindromeTest() throws Exception {

        String input = "No lemon no melon";

        assertTrue(palindrome.checkPalindrome(input));
    }
}
