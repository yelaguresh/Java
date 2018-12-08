package anagram;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTest {
	Anagram anagram=new Anagram();
	@Test
	public void test1() {
		assertTrue(anagram.checkAnagram("Mother In Law", "Hitler Woman"));
	}
	@Test
	public void test2() {
		assertTrue(anagram.checkAnagram("word", "wrdo"));
	}
	@Test
	public void test3() {
		assertFalse(anagram.checkAnagram("He", "She"));
	}
	@Test
	public void test4() {
		assertFalse(anagram.checkAnagram("joy", "enjoy"));
	}
	@Test
	public void test5() {
		assertTrue(anagram.checkAnagram("keEp", "peeK"));
	}

}
